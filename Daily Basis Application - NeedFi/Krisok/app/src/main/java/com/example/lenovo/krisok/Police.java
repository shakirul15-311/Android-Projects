package com.example.lenovo.krisok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Police extends AppCompatActivity {
    Button police,rajshaii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        police=(Button)findViewById(R.id.polic);
        rajshaii=(Button)findViewById(R.id.rajjj) ;

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dk=new Intent(Police.this,Dhakapolice.class);
                startActivity(dk);
            }
        });
        rajshaii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dk=new Intent(Police.this,Rajshaipolice.class);
                startActivity(dk);
            }
        });

    }
}
