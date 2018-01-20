package com.wix.boss.daily;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class search extends AppCompatActivity {
    Calendar c = Calendar.getInstance();

    Button s;
    EditText d;TextView res;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();

        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView2 = (AdView) findViewById(R.id.adView2);
        adView2.loadAd(adRequest);

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(search.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
// Call displayInterstitial() function
                displayInterstitial();
            }
        });
        s= (Button)findViewById(R.id.search_button2);

       final TextView   y_tv =(TextView)findViewById(R.id.year_tv2) ;
        final TextView   m_tv =(TextView)findViewById(R.id.month_tv2) ;
      final   TextView   d_tv =(TextView)findViewById(R.id.date_tv2) ;
       final TextView   we_tv =(TextView)findViewById(R.id.wekdays_tv2) ;
        res =(TextView)findViewById(R.id.textView2) ;
        d=(EditText)findViewById(R.id.date_E_text) ;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MMMM/d/E");
        String stdate =sdf.format(c.getTime());
        String values[] = stdate.split("/",0);
        y_tv.setText(values[0]);
        m_tv.setText(values[1]);
        d_tv.setText(values[2]);
        we_tv.setText(values[3]);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =openOrCreateDatabase("ajdibosh.db", MODE_PRIVATE, null);
                try {
                    //open the sqlite database
                    String se ;
                    String val[] =d.getText().toString().split("-");
                   se=val[0]+"-"+val[1];



                    // executed query set in the cursor object
                    Cursor c = db.rawQuery("select des from dib where date='"+se+"'", null);


                    //cursor move to the first
                    c.moveToFirst();
                    String tex = c.getString(c.getColumnIndex("des"));
                   res.setText(tex);

                }catch (Exception ex){
                    res.setText("কোন ফলাফল নেই");

                }

            }
        });

    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
