package com.example.lenovo.krisok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText user,pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        btn=(Button) findViewById(R.id.button4);

   btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if(user.getText().toString().equals("NeedFi")&& pass.getText().toString().equals("NeedFi"))
           {
               Toast.makeText(getApplicationContext(),"Log In Success",Toast.LENGTH_LONG);
               Intent my=new Intent(Login.this,Job.class);
               startActivity(my);
           }
       }
   });
    }
}
