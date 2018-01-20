package com.example.rakibul.touristspotandmarketplaceinbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Toutistplace extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toutistplace);
        listView = (ListView) findViewById(R.id.listView);
        String[] values;
        values = new String[]{"Ahsan Manzil", "Lalbagfort","Bangladesh National Museum","Liberation War Meusem","Bangladesh National Zoo","Botanikal Garden","Novo Theater","Air Force Musem","Jatiya sangsad Bhaban","Jatiyo Sriti Shoudho","Shaheed Minar","Sixty Dome Mosque","Dhakeshwari Temple","Sonargaon",
        "Sonargaon","Ramna Park","Gulshan Lake Park","Star Mosque (Tara Masjid)","Baitul Mukarram Mosque","Curzon Hall","Bangabandhu National Stadium","Sukanta's Dhamrai Metal Crafts","Bengal Gallery of Fine Arts"};
        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), ahsan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {

                    Intent myIntent = new Intent(view.getContext(), lalbag.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {

                    Intent myIntent = new Intent(view.getContext(), national_musum.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 3) {

                    Intent myIntent = new Intent(view.getContext(), liberationwar.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 4) {

                    Intent myIntent = new Intent(view.getContext(), zoo.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 5) {

                    Intent myIntent = new Intent(view.getContext(), botanikal.class);
                    startActivityForResult(myIntent, 0);
                }if (position == 6) {

                    Intent myIntent = new Intent(view.getContext(), novotheater.class);
                    startActivityForResult(myIntent, 0);
                }

            }


        });


    }
}