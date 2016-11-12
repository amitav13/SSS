package com.s3.s3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance(getString(R.string.intro_title), getString(R.string.intro_description),
                R.drawable.ic_brightness_7_black_24dp, getResources().getColor(R.color.colorPrimary)
                //,getResources().getColor(R.color.text_black), getResources().getColor(R.color.text_black)
        ));
        addSlide(new UserInputFragment());
//        addSlide(new RooftopAreaFragment());
        showSkipButton(false);
        setCustomTransformer(new ZoomOutPageTransformer());
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        UserInputFragment fragment = (UserInputFragment) currentFragment;
        IndianState state = IndianState.valueOf(fragment.indianStateSpinner.getSelectedItem().toString());
        int avgBill = Integer.parseInt(fragment.avgPrice.getText().toString());
        int rooftopArea = Integer.parseInt(fragment.rooftopArea.getText().toString());

        EventBus.getDefault().postSticky(new UserData(state, rooftopArea, avgBill));
        startActivity(new Intent(this, SavingsActivity.class));

    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
