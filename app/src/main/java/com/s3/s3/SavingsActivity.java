package com.s3.s3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        UserData userData = EventBus.getDefault().getStickyEvent(UserData.class);
        SolarModel model = new SolarModel(userData.avgBill, userData.rooftopArea, userData.state);
        kwSystem.setText("KW System: " + model.getKWSystem());
        annualSavings.setText("Annual Savings: " + model.getAnnualSavings());
        co2Offset.setText("CO2 offset: " + model.getCo2Offset());
    }
}
