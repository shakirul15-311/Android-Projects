package com.example.lenovo.krisok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    String tos,subs,messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText to=(EditText)findViewById(R.id.idm);
        final EditText sub=(EditText)findViewById(R.id.sub);
        final EditText message=(EditText)findViewById(R.id.message);
        Button sendbutton=(Button)findViewById(R.id.send);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 tos= to.getText().toString();
                subs=sub.getText().toString();
                messages=message.getText().toString();
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{tos});
                email.putExtra(Intent.EXTRA_SUBJECT,subs);
                email.putExtra(Intent.EXTRA_TEXT,messages);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"আপনার মতামত টি পাঠানোর জন্য মাধ্যম টি নির্ণয় করুন। ধন্যবাদ।"));


            }
        });
    }
}
