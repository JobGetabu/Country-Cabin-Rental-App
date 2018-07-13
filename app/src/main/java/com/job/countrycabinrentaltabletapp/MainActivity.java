package com.job.countrycabinrentaltabletapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.DATE;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView desc;
    private TextView dates;
    private RadioGroup radioGroup;
    private RadioButton ca1;
    private RadioButton ca2;
    private Button button;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        imageView = findViewById(R.id.ca_image);
        desc = findViewById(R.id.ca_description);
        dates = findViewById(R.id.ca_dates);
        radioGroup = findViewById(R.id.ca_radio);
        ca1 = findViewById(R.id.ca_radio1);
        ca2 = findViewById(R.id.ca_radio2);
        button = findViewById(R.id.btn);
        btnSave = findViewById(R.id.btnSave);

        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ca1));
        desc.setText(R.string.ca1_desc);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ca_radio1:
                        init(1);
                        break;
                    case R.id.ca_radio2:
                        init(2);
                        break;
                }
            }
        });

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar);
            }

        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void init(int ch) {

        if (ch == 1) {

            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ca1));
            desc.setText(R.string.ca1_desc);
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ca2));
            desc.setText(R.string.ca2_desc);

        }
    }

    private void updateLabel(Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        String ii = sdf.format(myCalendar.getTime());
        myCalendar.add(DATE,3);
        String jj = sdf.format(myCalendar.getTime());

        dates.setText(ii+" to "+jj);
    }
}
