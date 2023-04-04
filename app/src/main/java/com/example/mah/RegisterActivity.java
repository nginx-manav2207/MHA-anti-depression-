 package com.example.mah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class RegisterActivity extends AppCompatActivity {

     EditText edUsername,edEmail, edPassword, edConfirm ;
     Button btn;
     TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail= findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"mentalwellness",null,1);

                if (username.length() == 0 || email.length()==0 || password.length() == 0 || confirm.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.trim().equals(confirm.trim())){
                        if (isValid(password)) {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "1) Password must be atleast 8 character \n 2) should contain one character\n 3) should contain one digit\n 4)should contain a symbol", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
     public static boolean isValid(String pass)
     {
         int k=0,b=0,c=0;
         if(pass.length() < 8) {
             return false;
         }else  {
             for(int p=0;p<pass.length();p++) {
                 if (Character.isLetter(pass.charAt(p))) {
                     k = 1;
                 }
             }
             for(int q=0;q<pass.length();q++) {
                 if (Character.isDigit(pass.charAt(q))) {
                     b = 1;
                 }
             }
             for(int r=0;r<pass.length();r++){
                 char e = pass.charAt(r);
                 if(e>=33&&e<=46||e==64){
                     c=1;
                 }
             }
             if(k==1 && b==1 && c==1)
                 return true;
             else
                 return false;

         }
    }
}