package com.example.polygphone;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.polygphone.GyroSensorListenerAnkle;
import com.example.polygphone.GyroSensorListenerHip;
import com.example.polygphone.GyroSensorListenerKnee;

import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;

public class Transmission extends AppCompatActivity  {
    public enum BodyPart {
        Unknown,
        Hip,
        Knee,
        Ankle
    };


    private BodyPart selectedBodyPart = BodyPart.Unknown;
    private SensorManager mSensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmission);


        findViewById(R.id.hip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GyroSensorListenerHip gyro = new GyroSensorListenerHip();

                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                gyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

                mSensorManager.registerListener(gyro, gyroscope, SENSOR_DELAY_NORMAL);
                openHip();
            }
        });

        findViewById(R.id.knee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GyroSensorListenerKnee gyro = new GyroSensorListenerKnee();

                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                gyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

                mSensorManager.registerListener(gyro, gyroscope, SENSOR_DELAY_NORMAL);
                openKnee();
            }
        });

        findViewById(R.id.ankle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GyroSensorListenerAnkle gyro = new GyroSensorListenerAnkle();

                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                gyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

                mSensorManager.registerListener(gyro, gyroscope, SENSOR_DELAY_NORMAL);
                openAnkle();
            }
        });
    }

    public void hip() {

    }

    public void openHip() {
        Intent recording = new Intent(this, RecordingHip.class);
        startActivity(recording);
    }

    public void openKnee() {
        Intent recording = new Intent(this, RecordingKnee.class);
        startActivity(recording);
    }

    public void openAnkle() {
        Intent recording = new Intent(this, RecordingAnkle.class);
        startActivity(recording);
    }


}
