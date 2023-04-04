package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {

    private String[][] psy =
            {
                    {" Doctor Name : Ajit Saste", " Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {" Doctor Name : Prasad Pawar", " Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {" Doctor Name : Swapnil Kale", " Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "4300"},
                    {" Doctor Name : Deepak Deshmukh", " Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {" Doctor Name : Ashok Panda", " Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] cons=
            {
                    {" Doctor Name : Neelam Patil", " Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {" Doctor Name : Swati Pawar", " Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {" Doctor Name : Neerja Kale", " Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "3000"},
                    {" Doctor Name : Mayuri Deshmukh", " Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {" Doctor Name : Minakshi Panda", " Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };

    ImageButton btn;
    TextView tv;
    String[][] drdetail= {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewDDTitle);
        btn =(ImageButton) findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
            }
        });
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Psychiatrists") == 0) {
            drdetail = psy;
        }
        else {
            drdetail = cons;
        }


        list = new ArrayList();
        for (int i = 0; i<drdetail.length; i++) {
            item = new HashMap<String,String>();
            item.put("line1",drdetail[i][0]);
            item.put("line2",drdetail[i][1]);
            item.put("line3",drdetail[i][2]);
            item.put("line4",drdetail[i][3]);
            item.put("line5"," Cons Fee:"+drdetail[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookApointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",drdetail[i][0]);
                it.putExtra("text3",drdetail[i][1]);
                it.putExtra("text4",drdetail[i][3]);
                it.putExtra("text5",drdetail[i][4]);
                startActivity(it);
            }
        });
    }
}