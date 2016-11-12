package com.s3.s3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import org.greenrobot.eventbus.EventBus;

public class SystemTweakerActivity extends AppCompatActivity {

    Spinner invertorSpinner;
    Spinner panelSpinner;
    TickerView systemPrice;
    TickerView lifetimeUnits;
    TickerView paybackPeriod;
    TextView inverterComments;
    TextView panelComments;
    SolarModel model;
    Button findInstallers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_tweaker);

        invertorSpinner = (Spinner) findViewById(R.id.inverter_spinner);
        panelSpinner = (Spinner) findViewById(R.id.module_spinner);
        systemPrice = (TickerView) findViewById(R.id.systemPrice);
        lifetimeUnits = (TickerView) findViewById(R.id.lifetime_units);
        paybackPeriod = (TickerView) findViewById(R.id.payback);
        inverterComments = (TextView) findViewById(R.id.inverter_comments);
        panelComments = (TextView) findViewById(R.id.panel_comments);

        findInstallers = (Button) findViewById(R.id.find_installers);

        invertorSpinner.setAdapter(new ArrayAdapter<Inverter>(this, R.layout.spinner_item, Inverter.values()));
        panelSpinner.setAdapter(new ArrayAdapter<Panel>(this, R.layout.spinner_item, Panel.values()));
        invertorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelected();
                Inverter inverter = Inverter.valueOf(invertorSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        panelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelected();
                Panel panel = Panel.valueOf(panelSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        systemPrice.setCharacterList(TickerUtils.getDefaultNumberList());
        lifetimeUnits.setCharacterList(TickerUtils.getDefaultNumberList());
        paybackPeriod.setCharacterList(TickerUtils.getDefaultNumberList());

        UserData userData = EventBus.getDefault().getStickyEvent(UserData.class);
        model = new SolarModel(userData.avgBill, userData.rooftopArea, userData.state);

        findInstallers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SystemTweakerActivity.this, EPCListActivity.class));
            }
        });
    }

    public void itemSelected() {
        Panel panel = Panel.valueOf(panelSpinner.getSelectedItem().toString());
        Inverter inverter = Inverter.valueOf(invertorSpinner.getSelectedItem().toString());
        systemPrice.setText("Rs." + model.getSystemPrice(panel, inverter));
        lifetimeUnits.setText(model.getLifetimeUnits(panel, inverter) + " units");
        paybackPeriod.setText(model.getPayback(panel, inverter) + " years");
        inverterComments.setText(inverter.comment);
        panelComments.setText(panel.comment);
    }
}
