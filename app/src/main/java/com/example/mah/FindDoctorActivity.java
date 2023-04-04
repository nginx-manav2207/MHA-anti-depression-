package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FindDoctorActivity extends AppCompatActivity {
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        btn =(ImageButton) findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView councellors = findViewById(R.id.cardCouncellors);
        councellors.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Councellors");
                startActivity(it);
            }
        });

        CardView psychiatrists =findViewById(R.id.cardPsychiatrists);
        psychiatrists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title","Psychiatrists");
                startActivity(it);
            }
        });
    }
}