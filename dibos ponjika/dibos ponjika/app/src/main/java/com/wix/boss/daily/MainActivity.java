package com.wix.boss.daily;

import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();

    //get the current year,month and day
    String tex;
    int mo = c.get(Calendar.MONTH)+1;
    int d = c.get(Calendar.DAY_OF_MONTH);
     Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preloaderDbopenhelper pr=new preloaderDbopenhelper(this);
        getSupportActionBar().hide();
        pr.openDataBase();
        TextView tv=(TextView)findViewById(R.id.desc);
        TextView y_tv,m_tv,d_tv,we_tv;
        y_tv =(TextView)findViewById(R.id.year_tv) ;
        m_tv =(TextView)findViewById(R.id.month_tv) ;
        d_tv =(TextView)findViewById(R.id.date_tv) ;
        we_tv =(TextView)findViewById(R.id.wekdays_tv) ;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MMMM/d/E");
        String stdate =sdf.format(c.getTime());
        String values[] = stdate.split("/",0);
        y_tv.setText(values[0]);
        m_tv.setText(values[1]);
        d_tv.setText(values[2]);
        we_tv.setText(values[3]);
        String date = d+"-"+mo;

        search =(Button)findViewById(R.id.button3);
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder() .build();
        adView.loadAd(adRequest);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,viewall.class);
                startActivity(i);
            }
        });
        SQLiteDatabase db =openOrCreateDatabase("ajdibosh.db", MODE_PRIVATE, null);
        try{
            //open the sqlite database




            // executed query set in the cursor object
            Cursor c = db.rawQuery("select des from dib where date='"+date+"'", null);


            //cursor move to the first
            c.moveToFirst();
            tex=c.getString(c.getColumnIndex("des"));
            tv.setText(tex);
         NotificationCompat.Builder notficationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                 .setSmallIcon(android.R.drawable.stat_notify_error)

                  .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.aa))
                .setContentTitle("আজকের দিবস")
                  .setContentText(tex);
           notficationbuilder.setDefaults( Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);

           NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, notficationbuilder.build());





        }catch (Exception ex){

          //  Toast.makeText(getApplicationContext(), ex.toString(),
               //     Toast.LENGTH_LONG).show();
            ///  tv.setText("Today Has no date");
        }



    }

}
