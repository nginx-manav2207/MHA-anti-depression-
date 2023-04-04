package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookApointmentActivity extends AppCompatActivity {
    TextView tv;
    EditText ed1, ed2, ed3, ed4;
    private DatePickerDialog dpd;
    private TimePickerDialog tpd;
    private Button dateButton,timeButton,BBook;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_apointment);

        btn = (ImageButton) findViewById(R.id.imageButtonBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                startActivity(new Intent(BookApointmentActivity.this, FindDoctorActivity.class));
            }
        });

        tv = findViewById(R.id.textTitle);
        ed1 = findViewById(R.id.editTextFName);
        ed2 = findViewById(R.id.editTextContact);
        ed3 = findViewById(R.id.editTextFADD);
        ed4 = findViewById(R.id.editTextFEE);
        dateButton =findViewById(R.id.buttonDate);
        timeButton =findViewById(R.id.buttonTIME);
        BBook= findViewById(R.id.buttonBook);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String name = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fee = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(name);
        ed2.setText(contact);
        ed3.setText(address);
        ed4.setText(" Cons Fee:" + fee + "/-");

        Datepick();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpd.show();
            }
        });
        Timepick();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpd.show();
            }
        });

        BBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db=new Database(getApplicationContext(),"mentalwellness",null,1);
                SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sp.getString("username","").toString();

                if(db.checkAppointmentExisting(username,title+" => "+name,address,contact,dateButton.getText().toString(),timeButton.getText().toString())==1)
                    Toast.makeText(getApplicationContext(),"Appointment already exists", Toast.LENGTH_LONG).show();
                else{
                    db.addAppointment(username,title+" => "+name,address,contact,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fee));
                    Toast.makeText(getApplicationContext(), "Your Appointmnet Is Done Successfully", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    private void Datepick() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2+"/"+i1+"/"+i);

            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        dpd = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        dpd.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    private void Timepick() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
                timeButton.setText(i+":"+i1);

            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        tpd = new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
    }
}
