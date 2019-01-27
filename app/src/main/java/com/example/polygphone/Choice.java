package com.example.polygphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity {

    private Button CompareButton;
    private Button OverwriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        CompareButton = (Button) findViewById(R.id.Comparebutton);
        CompareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinish();
            }
        });

        OverwriteButton = (Button) findViewById(R.id.Overwritebutton);
        OverwriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompare();
            }
        });

    }

    public void openFinish() {
        Intent finish = new Intent(this, Finish.class);
        startActivity(finish);
    }

    public void openCompare() {
        Intent compare = new Intent(this, Compare.class);
        startActivity(compare);
    }
}
