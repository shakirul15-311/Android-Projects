package com.example.rakibul.touristspotandmarketplaceinbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class marketplace extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        listView = (ListView) findViewById(R.id.listView);
        String[] values;
        values = new String[]{"Jamuna Future Park","Bashundhara City Shopping Complex","BCS ComputerCity","Eastern Plaza Shopping Complex",
                "Shah Ali Plaza Shopping Complex","Shimanto Square Shopping Complex","Shyamoli Square Shopping Complex","New market","Rapa Plaz","Metro Shopping Mall","Multiplan Red Crescent City","Gausia Market","City Heart Shopping Complex","Lake City Shopping Mall","Mid Town Shopping Mall","Aarong Flagship Outlet","Fortune Shopping Mall"};

        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), jomu.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {

                    Intent myIntent = new Intent(view.getContext(), bosundhara.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {

                    Intent myIntent = new Intent(view.getContext(), BCSComputerCity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {

                    Intent myIntent = new Intent(view.getContext(), EasternPlaza.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 4) {

                    Intent myIntent = new Intent(view.getContext(), ShahAliPlaza.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 5) {

                    Intent myIntent = new Intent(view.getContext(), ShimantoSquare.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 6) {

                    Intent myIntent = new Intent(view.getContext(), ShyamoliSquare.class);
                    startActivityForResult(myIntent, 0);
                }

            }


        });


    }
}