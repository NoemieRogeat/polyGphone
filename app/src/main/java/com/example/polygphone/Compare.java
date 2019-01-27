package com.example.polygphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Compare extends AppCompatActivity {

    public Compare() {
    }

    LiveData liveData = new LiveData();
    List<LiveData.Coord> CoordinateHip;
    List<LiveData.Coord> CoordinateKnee;
    List<LiveData.Coord> CoordinateAnkle;

    public List<LiveData.Coord> getCoorHip() {
        return this.CoordinateHip;
    }

    public List<LiveData.Coord> getCoorKnee() {
        return this.CoordinateKnee;
    }

    public List<LiveData.Coord> getCoorAnkle() {
        return this.CoordinateAnkle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        CoordinateHip = liveData.getCoordHip();
        CoordinateKnee = liveData.getCoordKnee();
        CoordinateAnkle = liveData.getCoordAnkle();

    }
}
