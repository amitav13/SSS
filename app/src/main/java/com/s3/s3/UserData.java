package com.s3.s3;

/**
 * Created by Amitav on 11/12/2016.
 */

public class UserData {
    IndianState state;
    int rooftopArea;
    int avgBill;

    public UserData(IndianState state, int rooftopArea, int avgBill) {
        this.state = state;
        this.rooftopArea = rooftopArea;
        this.avgBill = avgBill;
    }
}
