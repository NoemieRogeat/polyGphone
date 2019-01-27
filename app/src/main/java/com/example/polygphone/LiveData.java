package com.example.polygphone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LiveData extends AppCompatActivity {

    public List<Coord> coordHip = new ArrayList<>();
    public List<Coord> coordKnee = new ArrayList<>();
    public List<Coord> coordAnkle = new ArrayList<>();

    public LiveData() {
    }

    public List<Coord> getCoordHip() {
        return this.coordHip;
    }

    public List<Coord> getCoordKnee() {
        return this.coordKnee;
    }

    public List<Coord> getCoordAnkle() {
        return this.coordAnkle;
    }

    public TextView g_HipX;
    public TextView g_HipY;
    public TextView g_HipZ;
    public TextView g_KneeX;
    public TextView g_KneeY;
    public TextView g_KneeZ;
    public TextView g_AnkleX;
    public TextView g_AnkleY;
    public TextView g_AnkleZ;
    DatabaseReference ref;

    public Button FinishButton;

    class Coord{
        double x; double y; double z;
        Coord(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        g_HipX = findViewById(R.id.HipX);
        g_HipY = findViewById(R.id.HipY);
        g_HipZ = findViewById(R.id.HipZ);
        g_KneeX = findViewById(R.id.KneeX);
        g_KneeY = findViewById(R.id.KneeY);
        g_KneeZ = findViewById(R.id.KneeZ);
        g_AnkleX = findViewById(R.id.AnkleX);
        g_AnkleY = findViewById(R.id.AnkleY);
        g_AnkleZ = findViewById(R.id.AnkleZ);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Activity");
        func();

//        FinishButton = (Button) findViewById(R.id.Finishbutton);
//        FinishButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openChoice();
//            }
//        });

        FinishButton = (Button) findViewById(R.id.Finishbutton);
        FinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinal();
            }
       });


    }

    public void openFinal() {
        Intent choose = new Intent(this, Final.class);
        startActivity(choose);
    }

//    public void openChoice() {
//        Intent choose = new Intent(this, Choice.class);
//        startActivity(choose);
//    }

    public void func() {


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataActivity) {
                g_KneeX.setText((String) dataActivity.child("Knee").child("x").getValue().toString());
                g_KneeY.setText((String) dataActivity.child("Knee").child("y").getValue().toString());
                g_KneeZ.setText((String) dataActivity.child("Knee").child("z").getValue().toString());


                String sx1 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double x1 = Double.parseDouble(sx1);
                String sy1 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double y1 = Double.parseDouble(sy1);
                String sz1 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double z1 = Double.parseDouble(sz1);
                coordKnee.add(new Coord(x1,y1,z1));

                if (coordKnee.size() > 500) {
                    coordKnee.remove(0);
                }


                g_HipX.setText((String) dataActivity.child("Hip").child("x").getValue().toString());
                g_HipY.setText((String) dataActivity.child("Hip").child("y").getValue().toString());
                g_HipZ.setText((String) dataActivity.child("Hip").child("z").getValue().toString());


                String sx2 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double x2 = Double.parseDouble(sx2);
                String sy2 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double y2 = Double.parseDouble(sy2);
                String sz2 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double z2 = Double.parseDouble(sz2);
                coordKnee.add(new Coord(x1,y1,z1));


                if (coordHip.size() > 500) {
                    coordHip.remove(0);
                }

                g_AnkleX.setText((String) dataActivity.child("Ankle").child("x").getValue().toString());
                g_AnkleY.setText((String) dataActivity.child("Ankle").child("y").getValue().toString());
                g_AnkleZ.setText((String) dataActivity.child("Ankle").child("z").getValue().toString());

                String sx3 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double x3 = Double.parseDouble(sx3);
                String sy3 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double y3 = Double.parseDouble(sy3);
                String sz3 = (String) dataActivity.child("Knee").child("x").getValue().toString();
                double z3 = Double.parseDouble(sz3);

                coordKnee.add(new Coord(x1,y1,z1));

                if (coordAnkle.size() > 500) {
                    coordAnkle.remove(0);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed to read value.", databaseError.toException());
            }
        });


    }


}