package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JournalsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    ImageButton btn;
    Switch sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);
        btn = findViewById(R.id.imageButtonBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JournalsActivity.this, HomeActivity.class));
            }
        });

        sb = findViewById(R.id.switchtoArticles);
        sb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle Switch button state change
                if (isChecked) {
                    startActivity(new Intent(JournalsActivity.this, ArticleActivity.class));
                } else {
                    // Do nothing or show a message to the user
                    Toast.makeText(JournalsActivity.this, "Switch is off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Listitem> items = new ArrayList<Listitem>();
        items.add(new Listitem("Journal of Mental Health", "The Journal of Mental Health is an international, peer-reviewed journal that provides a platform for researchers, clinicians, and policymakers to share their findings and perspectives on mental health. The journal publishes original research articles, review articles, case studies, and more, covering a wide range of topics related to mental health, including epidemiology, treatment, and prevention of mental disorders.\"\n" +
                "\n", R.drawable.ar1));
        items.add(new Listitem("Journal of Abnormal Psychology.", "The Journal of Counseling Psychology is a peer-reviewed journal that publishes original research articles, review articles, and case studies related to the theory, practice, and training of counseling psychology. The journal covers a broad range of topics, including psychotherapy, assessment, and counseling interventions",R.drawable.ar1));
        items.add(new Listitem("Journal of Counseling Psychology", "The Journal of Counseling Psychology is a peer-reviewed journal that publishes original research articles, review articles, and case studies related to the theory, practice, and training of counseling psychology. The journal covers a broad range of topics, including psychotherapy, assessment, and counseling interventions.", R.drawable.ar1));
        items.add(new Listitem("Journal of Child Psychology and Psychiatry", "The Journal of Child Psychology and Psychiatry is a leading peer-reviewed journal that publishes research on the development, assessment, and treatment of mental disorders in children and adolescents. The journal covers a wide range of topics, including cognitive, social, and emotional development, assessment of childhood disorders, and treatment approaches for childhood mental health issues.", R.drawable.ar1));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));


    }
}
