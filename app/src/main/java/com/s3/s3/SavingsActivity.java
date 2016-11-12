package com.s3.s3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

public class SavingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        TextView kwSystem = (TextView) findViewById(R.id.kw_system);
        TextView annualSavings = (TextView) findViewById(R.id.annual_savings);
        TextView co2Offset = (TextView) findViewById(R.id.co2_offset);
        Button exploreSystems = (Button) findViewById(R.id.explore_systems);
        exploreSystems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingsActivity.this, SystemTweakerActivity.class));
            }
        });

        UserData userData = EventBus.getDefault().getStickyEvent(UserData.class);
        SolarModel model = new SolarModel(userData.avgBill, userData.rooftopArea, userData.state);
        kwSystem.setText(model.getKWSystem() + " kWp");
        annualSavings.setText("Rs." + model.getAnnualSavings());
        co2Offset.setText(model.getCo2Offset() + " tons");
    }
}
