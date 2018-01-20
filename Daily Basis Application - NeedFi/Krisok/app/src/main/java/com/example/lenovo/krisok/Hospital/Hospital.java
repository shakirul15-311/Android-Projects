package com.example.lenovo.krisok.Hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.krisok.R;

public class Hospital extends AppCompatActivity {
    Button chittagong,myminsingho,sylhet,rangpur;
    Button khulna,dhaka,barisal,rajshai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        chittagong=(Button)findViewById(R.id.chittagong);
        khulna=(Button)findViewById(R.id.khulnabivag);
        dhaka=(Button)findViewById(R.id.dhaka);
        barisal=(Button)findViewById(R.id.barisal);
        myminsingho=(Button)findViewById(R.id.moymonsingh);
        sylhet=(Button)findViewById(R.id.shylet);
        rajshai=(Button)findViewById(R.id.rajshai);
        rangpur=(Button)findViewById(R.id.rangpur);
        chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bbb=new Intent(Hospital.this,Chittagong.class);
                startActivity(bbb);
            }
        });

    khulna.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ggg=new Intent(Hospital.this,Khulna.class);
            startActivity(ggg);
        }
    });
        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my=new Intent(Hospital.this,Dhakabivag.class);
                startActivity(my);
            }
        });
        barisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my=new Intent(Hospital.this,Barisal.class);
                startActivity(my);
            }
        });
        myminsingho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myv=new Intent(Hospital.this,Moymonsinghho.class);
                startActivity(myv);
            }
        });
        sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mu=new Intent(Hospital.this,SyletBivag.class);
            startActivity(mu);
            }
        });
        rajshai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myuk=new Intent(Hospital.this,RajshaiBivag.class);
                startActivity(myuk);
            }
        });
        rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mkkk=new Intent(Hospital.this,Rangpur.class);
                startActivity(mkkk);
            }
        });
    }
}
