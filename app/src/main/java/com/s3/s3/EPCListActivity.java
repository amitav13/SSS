package com.s3.s3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EPCListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epclist);
        final ImageView image = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load(R.drawable.epclist).into(image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(EPCListActivity.this).load(R.drawable.checklist).into(image);
            }
        });
    }
}
