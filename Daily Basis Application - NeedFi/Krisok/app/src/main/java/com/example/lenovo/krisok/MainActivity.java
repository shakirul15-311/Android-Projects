package com.example.lenovo.krisok;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.lenovo.krisok.Hospital.Hospital;
import com.example.lenovo.krisok.Hospital.Menu1;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static int Time=4000;
ImageButton feedback,calll,offday,police;
    ImageButton daily,hospital,tution,job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

feedback=(ImageButton)findViewById(R.id.feedback);
        daily=(ImageButton)findViewById(R.id.dailyno);
        hospital=(ImageButton)findViewById(R.id.hospital);
        job=(ImageButton)findViewById(R.id.job);
        tution=(ImageButton)findViewById(R.id.tution);
        calll=(ImageButton)findViewById(R.id.call);
        offday=(ImageButton)findViewById(R.id.imageButton2);
        police=(ImageButton)findViewById(R.id.imageButton);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my=new Intent(MainActivity.this,Feedback.class);
                startActivity(my);
            }
        });
       daily.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent to=new Intent(MainActivity.this,Dailynote.class);
               startActivity(to);
           }
       });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myi=new Intent(MainActivity.this,Hospital.class);
                startActivity(myi);
            }
        });
        tution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myi=new Intent(MainActivity.this,LoginTwo.class);
                startActivity(myi);
            }
        });



     job.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent myonu=new Intent(MainActivity.this,Login.class);
             startActivity(myonu);
         }
     });


        calll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myu=new Intent(MainActivity.this,Call.class);
                startActivity(myu);
            }
        });

offday.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent mu=new Intent(MainActivity.this,Off.class);
        startActivity(mu);
    }
});
police.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent mi=new Intent(MainActivity.this,Police.class);
        startActivity(mi);
    }
});













        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu1) {
            Intent ne=new Intent(MainActivity.this,About.class);
            startActivity(ne);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {
            Intent ne=new Intent(MainActivity.this,Terms.class);
            startActivity(ne);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
