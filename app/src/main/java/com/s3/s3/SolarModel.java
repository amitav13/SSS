package com.s3.s3;

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

    public SolarModel(int avgBill, int rooftopArea, IndianState state) {
        this.avgBill = avgBill;
        this.rooftopArea = rooftopArea;
        this.state = state;
        numberOfUnitsUsed = avgBill/state.pricePerUnit;
        kwSystem = numberOfUnitsUsed/(30 * state.avgIrradiation);
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
}
