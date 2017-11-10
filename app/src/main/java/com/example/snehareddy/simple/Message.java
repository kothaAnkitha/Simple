package com.example.snehareddy.simple;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Message extends AppCompatActivity {

  private  EditText e_contact, e_message;
   private TextView mDisplay1,mDisplay2;
   private Button b_date, b_time;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        e_contact = (EditText) findViewById(R.id.e_contact);
        e_message = (EditText) findViewById(R.id.e_message);
        mDisplay1 = (TextView) findViewById(R.id.tview1);
        mDisplay2 = (TextView) findViewById(R.id.tview2);
        b_date = (Button) findViewById(R.id.bdate);
        b_time = (Button) findViewById(R.id.btime);
        b_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Message.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setTitle("select date");
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                //Log.d(TAG,"onDateSet:date:"+dayOfMonth+"/"+month+"/"+year);
                String date=year+"/"+month+"/"+dayOfMonth;
                mDisplay1.setText(date);
            }
        };
        b_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour_x = c.get(Calendar.HOUR_OF_DAY);
                int minute_x = c.get(Calendar.MINUTE);
                TimePickerDialog pickerDialog = new TimePickerDialog(
                        Message.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mTimeSetListener,
                        hour_x, minute_x, false);
                pickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                pickerDialog.setTitle("select date");
                pickerDialog.show();

            }
        });
        mTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+":"+minute;
                mDisplay2.setText(time);
            }
        };

    }
}