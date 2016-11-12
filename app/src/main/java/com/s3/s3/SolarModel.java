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
        systemPrice = ((Double)(kwSystem * 65000)).intValue();
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

    public int getSystemPrice(Panel panel, Invertor invertor) {
        systemPrice = ((Double)(kwSystem * getRatio(panel, invertor))).intValue();
        return systemPrice;
    }

    public int getLifetimeUnits(Panel panel, Invertor invertor) {
        lifetimeUnits = getLifetimeUnitsRatio(panel, invertor) * 25;
        return lifetimeUnits;
    }

    public int getRatio(Panel panel, Invertor invertor) {
        if (panel == Panel.CanadianSolar && invertor == Invertor.SMA) {
            return 65000;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.SMA) {
            return 65000;
        } else if (panel == Panel.Sonali && invertor == Invertor.SMA) {
            return 54600;
        } else if (panel == Panel.CanadianSolar && invertor == Invertor.Fronius) {
            return 61000;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.Fronius) {
            return 61000;
        } else if (panel == Panel.Sonali && invertor == Invertor.Fronius) {
            return 50600;
        } else if (panel == Panel.CanadianSolar && invertor == Invertor.Growatt) {
            return 58000;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.Growatt) {
            return 58000;
        } else if (panel == Panel.Sonali && invertor == Invertor.Growatt) {
            return 47600;
        }
        return 65000;
    }

    public int getLifetimeUnitsRatio(Panel panel, Invertor invertor) {
        if (panel == Panel.CanadianSolar && invertor == Invertor.SMA) {
            return 1497;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.SMA) {
            return 1478;
        } else if (panel == Panel.Sonali && invertor == Invertor.SMA) {
            return 1384;
        } else if (panel == Panel.CanadianSolar && invertor == Invertor.Fronius) {
            return 1482;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.Fronius) {
            return 1464;
        } else if (panel == Panel.Sonali && invertor == Invertor.Fronius) {
            return 1398;
        } else if (panel == Panel.CanadianSolar && invertor == Invertor.Growatt) {
            return 1485;
        } else if (panel == Panel.VikramEldora && invertor == Invertor.Growatt) {
            return 1461;
        } else if (panel == Panel.Sonali && invertor == Invertor.Growatt) {
            return 1375;
        }
        return 1400;
    }
}
