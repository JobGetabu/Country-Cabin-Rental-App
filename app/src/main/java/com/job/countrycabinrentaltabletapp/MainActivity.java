package com.job.countrycabinrentaltabletapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        ImageView imageView = findViewById(R.id.ca_image);
        TextView desc = findViewById(R.id.ca_description);
        TextView dates = findViewById(R.id.ca_dates);
        RadioGroup radioGroup = findViewById(R.id.ca_radio);
        RadioButton ca1 = findViewById(R.id.ca_radio1);
        RadioButton ca2 = findViewById(R.id.ca_radio2);
        Button button = findViewById(R.id.btn);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ca_radio1:
                        // do operations specific to this selection
                        break;
                    case R.id.ca_radio2:
                        // do operations specific to this selection
                        break;
                }
            }
        });
    }

    private void init() {

    }
}
