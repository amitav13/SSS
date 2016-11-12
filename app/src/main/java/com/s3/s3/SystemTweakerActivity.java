package com.s3.s3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import org.greenrobot.eventbus.EventBus;

public class SystemTweakerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner invertorSpinner;
    Spinner panelSpinner;
    TickerView systemPrice;
    TickerView lifetimeUnits;
    SolarModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_tweaker);

        invertorSpinner = (Spinner) findViewById(R.id.inverter_spinner);
        panelSpinner = (Spinner) findViewById(R.id.module_spinner);
        systemPrice = (TickerView) findViewById(R.id.systemPrice);
        lifetimeUnits = (TickerView) findViewById(R.id.lifetime_units);

        invertorSpinner.setAdapter(new ArrayAdapter<Invertor>(this, R.layout.spinner_item, Invertor.values()));
        panelSpinner.setAdapter(new ArrayAdapter<Panel>(this, R.layout.spinner_item, Panel.values()));
        invertorSpinner.setOnItemSelectedListener(this);
        panelSpinner.setOnItemSelectedListener(this);

        systemPrice.setCharacterList(TickerUtils.getDefaultNumberList());
        lifetimeUnits.setCharacterList(TickerUtils.getDefaultNumberList());

        UserData userData = EventBus.getDefault().getStickyEvent(UserData.class);
        model = new SolarModel(userData.avgBill, userData.rooftopArea, userData.state);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Panel panel = Panel.valueOf(panelSpinner.getSelectedItem().toString());
        Invertor invertor = Invertor.valueOf(invertorSpinner.getSelectedItem().toString());
        systemPrice.setText("Rs." + model.getSystemPrice(panel, invertor));
        lifetimeUnits.setText(model.getLifetimeUnits(panel, invertor) + "units");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
