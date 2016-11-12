package com.s3.s3;

import java.text.DecimalFormat;

/**
 * Created by Amitav on 11/12/2016.
 */

public class SolarModel {

    int avgBill;
    int rooftopArea;
    IndianState state;
    double numberOfUnitsUsed;
    double kwSystem;
    int annualSavings;
    int co2Offset;
    int systemPrice;
    int lifetimeUnits;
    int payback;

    public SolarModel(int avgBill, int rooftopArea, IndianState state) {
        this.avgBill = avgBill;
        this.rooftopArea = rooftopArea;
        this.state = state;
        numberOfUnitsUsed = avgBill/state.pricePerUnit;
        kwSystem = numberOfUnitsUsed/(30 * state.avgIrradiation);
        DecimalFormat df = new DecimalFormat("#.##");
        kwSystem = Double.valueOf(df.format(kwSystem));
        annualSavings = ((Double)(kwSystem * state.avgIrradiation * 365 * state.pricePerUnit)).intValue();
        co2Offset = ((Double)(kwSystem * state.avgIrradiation * 365 * 25 * 0.94/907)).intValue();
    }

    public double getKWSystem() {
        return kwSystem;
    }

    public int getAnnualSavings() {
        return annualSavings;
    }

    public int getCo2Offset() {
        return co2Offset;
    }

    public int getSystemPrice(Panel panel, Inverter inverter) {
        systemPrice = ((Double)(kwSystem * getSystemPriceRatio(panel, inverter))).intValue();
        return systemPrice;
    }

    public int getLifetimeUnits(Panel panel, Inverter inverter) {
        lifetimeUnits = getLifetimeUnitsRatio(panel, inverter) * 25;
        return lifetimeUnits;
    }

    public int getPayback(Panel panel, Inverter inverter) {
        double paybackk = (getSystemPrice(panel, inverter) * 25)/(getLifetimeUnits(panel, inverter) * getKWSystem() * state.pricePerUnit);
        payback = ((Double)paybackk).intValue();
        return payback;
    }

    public int getSystemPriceRatio(Panel panel, Inverter inverter) {
        if (panel == Panel.CanadianSolar && inverter == Inverter.SMA) {
            return 65000;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.SMA) {
            return 65000;
        } else if (panel == Panel.Sonali && inverter == Inverter.SMA) {
            return 54600;
        } else if (panel == Panel.CanadianSolar && inverter == Inverter.Fronius) {
            return 61000;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.Fronius) {
            return 61000;
        } else if (panel == Panel.Sonali && inverter == Inverter.Fronius) {
            return 50600;
        } else if (panel == Panel.CanadianSolar && inverter == Inverter.Growatt) {
            return 58000;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.Growatt) {
            return 58000;
        } else if (panel == Panel.Sonali && inverter == Inverter.Growatt) {
            return 47600;
        }
        return 65000;
    }

    public int getLifetimeUnitsRatio(Panel panel, Inverter inverter) {
        if (panel == Panel.CanadianSolar && inverter == Inverter.SMA) {
            return 1497;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.SMA) {
            return 1478;
        } else if (panel == Panel.Sonali && inverter == Inverter.SMA) {
            return 1384;
        } else if (panel == Panel.CanadianSolar && inverter == Inverter.Fronius) {
            return 1482;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.Fronius) {
            return 1464;
        } else if (panel == Panel.Sonali && inverter == Inverter.Fronius) {
            return 1398;
        } else if (panel == Panel.CanadianSolar && inverter == Inverter.Growatt) {
            return 1485;
        } else if (panel == Panel.VikramEldora && inverter == Inverter.Growatt) {
            return 1461;
        } else if (panel == Panel.Sonali && inverter == Inverter.Growatt) {
            return 1375;
        }
        return 1400;
    }
}
