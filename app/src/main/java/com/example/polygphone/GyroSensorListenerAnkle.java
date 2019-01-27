package com.example.polygphone;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GyroSensorListenerAnkle implements SensorEventListener {
    DatabaseReference ref;

    GyroSensorListenerAnkle() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("Activity/Ankle");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        ref.child("x").setValue(Math.floor(event.values[0]*360));
        ref.child("y").setValue(Math.floor(event.values[1]*360));
        ref.child("z").setValue(Math.floor(event.values[2]*360));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
