package com.example.lenovo.krisok;



        import android.Manifest;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.InputType;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class Call extends AppCompatActivity implements View.OnClickListener {
    Button call, one, two, three, four, five, six, seven, eight, nine, zero, star, hash, btnbksp;
    String str = "";
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        star = (Button) findViewById(R.id.btnstar);
        hash = (Button) findViewById(R.id.btnhash);
        btnbksp = (Button) findViewById(R.id.btnbs);
        call = (Button) findViewById(R.id.buttoncall);
        number = (EditText) findViewById(R.id.callnum);
        number.setInputType(InputType.TYPE_NULL);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        star.setOnClickListener(this);
        hash.setOnClickListener(this);

        btnbksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                number.setText("" + str);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String callnumber = number.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode(callnumber)));
                if (ActivityCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        String value = "";
        switch (id) {
            case R.id.btn0:
                value = "0";
                str += value;
                number.setText(str);
                break;
            case R.id.btn1:
                value = "1";
                str += value;
                number.setText(str);
                break;
            case R.id.btn2:
                value = "2";
                str += value;
                number.setText(str);
                break;
            case R.id.btn3:
                value = "3";
                str += value;
                number.setText(str);
                break;
            case R.id.btn4:
                value = "4";
                str += value;
                number.setText(str);
                break;
            case R.id.btn5:
                value = "5";
                str += value;
                number.setText(str);
                break;
            case R.id.btn6:
                value = "6";
                str += value;
                number.setText(str);
                break;
            case R.id.btn7:
                value = "7";
                str += value;
                number.setText(str);
                break;
            case R.id.btn8:
                value = "8";
                str += value;
                number.setText(str);
                break;
            case R.id.btn9:
                value = "9";
                str += value;
                number.setText(str);
                break;
            case R.id.btnstar:
                value = "*";
                str += value;
                number.setText(str);
                break;
            case R.id.btnhash:
                value = "#";
                str += value;
                number.setText(str);
                break;
        }
    }
}
