package com.example.lenovo.krisok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dailynote extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1;
    Sqlite my;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailynote);


        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        b1 = (Button) findViewById(R.id.button2);
        t1 = (TextView) findViewById(R.id.textView2);
        my = new Sqlite(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checker = my.addtotable(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString());
                if (checker == true) {

                    Toast.makeText(Dailynote.this, "ডাটাটি লিপিবদ্ধ হয়েছে।", Toast.LENGTH_LONG).show();

                } else

                {
                    Toast.makeText(Dailynote.this, "ডাটাটি লিপিবদ্ধ হয় নাই। পুনরায় চেষ্টা করুণ।", Toast.LENGTH_LONG).show();

                }


            }
        });


    }


    public void viewdata(View view) {
        Cursor result = my.display();
        if (result.getCount() == 0) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_LONG).show();

        }
        result.moveToFirst();
        StringBuffer buffer = new StringBuffer();
        do {
            buffer.append("কাজের আইডি:" + result.getString(0) + "\n");
            buffer.append("কাজটির ধরন:" + result.getString(1) + "\n");
            buffer.append("কাজের বর্ণনা:" + result.getString(2) + "\n");
            buffer.append("কাজের শেষ সময়:" + result.getString(3) + "\n\n");
        }
        while (result.moveToNext());
        Display(buffer.toString());

    }

    public void Display(String data) {
        t1.setText(data);
    }

    public void deletedata(View view) {
        int deletechecker = my.deletedata(e1.getText().toString());
        if (deletechecker > 0) {
            Toast.makeText(Dailynote.this, "কেটে গিছে।", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Dailynote.this, "কাটে নাই সঠিক আইডি নির্ণয় করুন।", Toast.LENGTH_LONG).show();
        }


    }
}
