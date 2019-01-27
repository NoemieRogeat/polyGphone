package com.example.polygphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
    int TotalHipX = 0;
    int TotalHipY = 0;
    int TotalHipZ = 0;
    int TotalKneeX = 0;
    int TotalKneeY = 0;
    int TotalKneeZ = 0;
    int TotalAnkleX = 0;
    int TotalAnkleY = 0;
    int TotalAnkleZ = 0;
    int TotalHip2X = 0;
    int TotalHip2Y = 0;
    int TotalHip2Z = 0;
    int TotalKnee2X = 0;
    int TotalKnee2Y= 0;
    int TotalKnee2Z = 0;
    int TotalAnkle2X = 0;
    int TotalAnkle2Y = 0;
    int TotalAnkle2Z = 0;
    int diffhipX;
    int diffhipY;
    int diffhipZ;
    int diffkneeX;
    int diffkneeY;
    int diffkneeZ;
    int diffankleX;
    int diffankleY;
    int diffankleZ;

    public TextView HipX;
    public TextView HipY;
    public TextView HipZ;
    public TextView KneeX;
    public TextView KneeY;
    public TextView KneeZ;
    public TextView AnkleX;
    public TextView AnkleY;
    public TextView AnkleZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        HipX = findViewById(R.id.HipX);
        HipY = findViewById(R.id.HipY);
        HipZ = findViewById(R.id.HipZ);
        KneeX = findViewById(R.id.KneeX);
        KneeY = findViewById(R.id.KneeY);
        KneeZ = findViewById(R.id.KneeZ);
        AnkleX = findViewById(R.id.AnkleX);
        AnkleY = findViewById(R.id.AnkleY);
        AnkleZ = findViewById(R.id.AnkleZ);

        CoordinateActualHip = liveData.getCoordHip();
        CoordinateActualKnee = liveData.getCoordKnee();
        CoordinateActualAnkle = liveData.getCoordAnkle();

        CoordinateCompareHip = comparison.getCoorHip();
        CoordinateCompareKnee = comparison.getCoorKnee();
        CoordinateCompareAnkle = comparison.getCoorAnkle();

        for (int i=0; i < CoordinateActualHip.size(); i++){
            TotalHipX += CoordinateActualHip.get(i).x;
            TotalHipY += CoordinateActualHip.get(i).y;
            TotalHipZ += CoordinateActualHip.get(i).z;
        }

        for (int i=0; i < CoordinateActualKnee.size(); i++){
            TotalKneeX += CoordinateActualHip.get(i).x;
            TotalKneeY += CoordinateActualHip.get(i).y;
            TotalKneeZ += CoordinateActualHip.get(i).z;
        }

        for (int i=0; i < CoordinateActualAnkle.size(); i++){
            TotalAnkleX += CoordinateActualHip.get(i).x;
            TotalAnkleY += CoordinateActualHip.get(i).y;
            TotalAnkleZ += CoordinateActualHip.get(i).z;
        }

        for (int i=0; i < CoordinateCompareHip.size(); i++){
            TotalHip2X += CoordinateCompareHip.get(i).x;
            TotalHip2Y += CoordinateCompareHip.get(i).y;
            TotalHip2Z += CoordinateCompareHip.get(i).z;
        }

        for (int i=0; i < CoordinateCompareKnee.size(); i++){
            TotalKnee2X += CoordinateCompareHip.get(i).x;
            TotalKnee2Y += CoordinateCompareHip.get(i).y;
            TotalKnee2Z += CoordinateCompareHip.get(i).z;
        }

        for (int i=0; i < CoordinateCompareAnkle.size(); i++){
            TotalAnkle2X += CoordinateCompareHip.get(i).x;
            TotalAnkle2Y += CoordinateCompareHip.get(i).y;
            TotalAnkle2Z += CoordinateCompareHip.get(i).z;
        }

        diffhipX = abs(TotalHipX-TotalHip2X);
        diffhipY = abs(TotalHipY-TotalHip2Y);
        diffhipZ = abs(TotalHipZ-TotalHip2Z);
        diffankleX = abs(TotalAnkleX-TotalAnkle2X);
        diffankleY = abs(TotalAnkleY-TotalAnkle2Y);
        diffankleZ = abs(TotalAnkleZ-TotalAnkle2Z);
        diffkneeX = abs(TotalKneeX-TotalKnee2X);
        diffkneeY = abs(TotalKneeY-TotalKnee2Y);
        diffkneeZ = abs(TotalKneeZ-TotalKnee2Z);

        HipX.setText(diffhipX);
        HipY.setText(diffhipY);
        HipZ.setText(diffhipZ);
        KneeX.setText(diffkneeX);
        KneeY.setText(diffkneeY);
        KneeZ.setText(diffkneeZ);
        AnkleX.setText(diffankleX);
        AnkleY.setText(diffankleY);
        AnkleZ.setText(diffankleZ);


    }

    private int abs(int i) {
        if (i >0){
            return i;
        } else {
            return -i;
        }
    }
}
