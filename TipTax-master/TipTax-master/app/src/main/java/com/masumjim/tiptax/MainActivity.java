package com.masumjim.tiptax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        /*private static int SPLASH_TIME_OUT = 4000;*/
        private EditText totalBillAmount;
        private SeekBar taxPercent;
        private SeekBar tipPercent;

        private SeekBar tipsNumberOfPeople;
        private TextView totalAmountToBePaid;
        private TextView totalAmountOfTipsToBePaid;
        private TextView tipsPerPerson;
        private Button calculateTips;
        private int taxPercentValue = 0;
        private int tipPercentValue = 0;

        private int tipsForNumberOfPeople = 0;

        private TextView taxPercentLabel;
        private TextView tipPercentLabel;

        private TextView splitNumberLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent (MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);*/


        totalBillAmount = (EditText)findViewById(R.id.bill_value);
        taxPercent = (SeekBar)findViewById(R.id.seekBar);
        tipsNumberOfPeople = (SeekBar)findViewById(R.id.seekBar_one);
        tipPercent = (SeekBar)findViewById(R.id.seekBar2);
        totalAmountToBePaid = (TextView)findViewById(R.id.total_to_pay_result);
        totalAmountOfTipsToBePaid = (TextView)findViewById(R.id.total_tip_result);
        tipsPerPerson = (TextView)findViewById(R.id.tip_per_person_result);
        tipPercentLabel = (TextView)findViewById(R.id.tip_percent);
        taxPercentLabel = (TextView)findViewById(R.id.tax_percent);
        splitNumberLabel = (TextView)findViewById(R.id.split_number);



        tipPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentValue = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercentLabel.setText("Tip Percent    " + seekBar.getProgress());
            }

        });
        taxPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                taxPercentValue = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                taxPercentLabel.setText("Tax Percent    " + seekBar.getProgress());
            }

        });
        tipsNumberOfPeople.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipsForNumberOfPeople = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                splitNumberLabel.setText("Number of Waiter    " + seekBar.getProgress());
            }
        });

        calculateTips = (Button) findViewById(R.id.calculate_tips);
        calculateTips.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (totalBillAmount.getText().toString().equals("") || totalBillAmount.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Input Please", Toast.LENGTH_SHORT).show();
                    return;
                }
                double totalBillInput = Double.parseDouble(totalBillAmount.getText().toString());
                if (tipPercentValue == 0 || tipsForNumberOfPeople == 0 || taxPercentValue == 0) {
                    Toast.makeText(getApplicationContext(), "Please Set Values", Toast.LENGTH_SHORT).show();
                    return;
                }
                double percentageOfTax = (totalBillInput * taxPercentValue) / 100;
                double billandTax = totalBillInput + percentageOfTax;
                double percentageOfTip = ( billandTax * tipPercentValue) / 100;
                double totalAmountForTheBill = totalBillInput + percentageOfTip + percentageOfTax;
                double tipPerEachPerson = percentageOfTip / tipsForNumberOfPeople;
                totalAmountToBePaid.setText(removeTrailingZero(String.valueOf(String.format("%.2f", totalAmountForTheBill))));
                totalAmountOfTipsToBePaid.setText(removeTrailingZero(String.valueOf(String.format("%.2f", percentageOfTip))));
                tipsPerPerson.setText(removeTrailingZero(String.valueOf(String.format("%.2f", tipPerEachPerson))));
            }
        });
    }
    public String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(".")) {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if (newValue.startsWith(".0")) {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }
}