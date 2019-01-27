package com.example.polygphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Finish extends AppCompatActivity {

    Compare comparison = new Compare();
    LiveData liveData = new LiveData();
    List<LiveData.Coord> CoordinateActualHip;
    List<LiveData.Coord> CoordinateActualKnee;
    List<LiveData.Coord> CoordinateActualAnkle;
    List<LiveData.Coord> CoordinateCompareHip;
    List<LiveData.Coord> CoordinateCompareKnee;
    List<LiveData.Coord> CoordinateCompareAnkle;
    List<LiveData.Coord> DifferenceHip;
    List<LiveData.Coord> DifferenceKnee;
    List<LiveData.Coord> DifferenceAnkle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        CoordinateActualHip = liveData.getCoordHip();
        CoordinateActualKnee = liveData.getCoordKnee();
        CoordinateActualAnkle = liveData.getCoordAnkle();

        CoordinateCompareHip = comparison.getCoorHip();
        CoordinateCompareKnee = comparison.getCoorKnee();
        CoordinateCompareAnkle = comparison.getCoorAnkle();


    }
}
