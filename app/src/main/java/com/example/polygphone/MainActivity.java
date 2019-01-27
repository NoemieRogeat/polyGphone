package com.example.polygphone;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.polygphone.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button TransmitterButton;
    private Button ReceiverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TransmitterButton = (Button) findViewById(R.id.Transbutton);
        TransmitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransmitter();
            }
        });

        ReceiverButton = (Button) findViewById(R.id.Recbutton);
        ReceiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcome();
            }
        });

    }

    public void openTransmitter() {
        Intent transmit = new Intent(this, Transmission.class);
        startActivity(transmit);
    }

    public void openWelcome() {
        Intent receive = new Intent(this, Welcome.class);
        startActivity(receive);
    }

}

