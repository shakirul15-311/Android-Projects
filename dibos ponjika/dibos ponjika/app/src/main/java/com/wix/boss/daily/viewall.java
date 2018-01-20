package com.wix.boss.daily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class viewall extends AppCompatActivity {


    MyCustomAdapter myCustomAdapter = null;
    ArrayList<Dates> dt = null;
    preloaderDbopenhelper mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);




        mv = new preloaderDbopenhelper(this);

        dt = mv.getData();
        myCustomAdapter = new MyCustomAdapter(this, R.layout.item, dt);
        ListView listView = (ListView) findViewById(R.id.mylsit);

        listView.setAdapter(myCustomAdapter);


    }



}
