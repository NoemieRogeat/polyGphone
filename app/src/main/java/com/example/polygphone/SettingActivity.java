package com.example.polygphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {

    int height;
    double shoeSize;

    EditText heightInput;
    EditText shoesSizeInput;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        heightInput = (EditText) findViewById(R.id.numberHeight);
        shoesSizeInput = (EditText) findViewById(R.id.shoesSize) ;

        submitButton = (Button) findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Integer.valueOf(heightInput.getText().toString());
                shoeSize = Double.valueOf(shoesSizeInput.getText().toString());

                openActivityBack();

            }
        });

    }

    public void openActivityBack() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}