package com.s3.s3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SavingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        TextView kwSystem = (TextView) findViewById(R.id.kw_system);
        TextView annualSavings = (TextView) findViewById(R.id.annual_savings);
        TextView co2Offset = (TextView) findViewById(R.id.co2_offset);
    }
}
