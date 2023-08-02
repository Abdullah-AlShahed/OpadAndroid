package com.example.opad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.opad.R;

public class CalculatorActivity extends AppCompatActivity {
    TextView top_tv;
    TextView result_tv;
    StringBuilder rtvText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result_tv = findViewById(R.id.tv_result_view);
        rtvText=new StringBuilder();
        top_tv = findViewById(R.id.tv_top_small);

    }
    //2nd Way to make actions with the button
    public void onDigitClick(View view) {
        Button clicked = (Button) view;
        String clickedText = clicked.getText().toString();
        rtvText.append(clickedText);

        if (clickedText.equals(".")) {
            if (result_tv.toString().contains(".")) {
                return;
            }
        }
        checkDigitLength();

        result_tv.append(clickedText);
        top_tv.append(clickedText);

    }

    String savedNum = "";
    String savedOperator = "";

    public void onOperatorClick(View view) {
        Button clickedOperator = (Button) view;
        String clickedOperatorText = clickedOperator.getText().toString();
        if ("=".equals(rtvText.charAt(rtvText.length() - 1))){
            clearCalculator();
        }
        rtvText.append(clickedOperatorText);
        if ("SR".equals(clickedOperatorText) || "^2".equals(clickedOperatorText)) {
            savedOperator = clickedOperatorText;
            savedNum = result_tv.getText().toString();
            String lastNum = "0";
            savedNum = calc(savedNum, savedOperator, lastNum);
            result_tv.setText(savedNum);
        } if (savedOperator.isEmpty()) {
            savedNum = result_tv.getText().toString();
            savedOperator = clickedOperatorText;
            result_tv.setText("");
            top_tv.append(" " + savedOperator + " ");
        } else {
            String lastNum = result_tv.getText().toString();
            savedNum = calc(savedNum, savedOperator, lastNum);
            result_tv.setText(savedNum);
            savedOperator = clickedOperatorText;
            result_tv.setText("");
            top_tv.setText(savedNum + " " + savedOperator + " ");
        }
    }


    private String calc(String savedNum, String savedOperator, String lastNum) {
        double num1 = Double.parseDouble(savedNum);
        double num2 = Double.parseDouble(lastNum);
        double result=0.0;

        if (savedOperator.equals("+")) {
             result = num1 + num2;
        } else if (savedOperator.equals("-")) {
             result = num1 - num2;
        } else if (savedOperator.equals("x")) {
             result = (double) Math.multiplyExact((long) num1,(long) num2);
        } else if (savedOperator.equals("/")) {
            if (num2 != 0) {
                 result = num1 / num2;
            } else {
                clearCalculator();
                result_tv.setText("Error: Division by zero");
                return "";
            }
        } else if (savedOperator.equals("SR")) {
            if (num1 >= 0) {
                 result = Math.sqrt(num1);
            } else {
                clearCalculator();
                result_tv.setText("Error: Invalid input for square root");
                return "";
            }
        } else if (savedOperator.equals("^2")) {
             result = Math.pow(num1, 2);
        }
        return ""+result;
    }

    public void onEqualClick(View view) {
        Button clicked = (Button) view;
        String clickedText = clicked.getText().toString();
        rtvText.append(clickedText);

        String lastNum = result_tv.getText().toString();
        savedNum = calc(savedNum, savedOperator, lastNum);
        result_tv.setText(savedNum);

    }

    //****************************************************************
    public void onDeleteClick(View view) {
        String rtv= result_tv.getText().toString();
        rtvText.append(rtv);
        if (rtvText.length() > 0) {
            rtvText.deleteCharAt(rtvText.length()-1);
           result_tv.setText(rtvText.toString());

           top_tv.append(result_tv.getText() + " " + savedOperator + " ");
        }
        checkDigitLength();
    }
    public void onDeleteAllClick(View view) {
        clearCalculator();
    }
    public void checkDigitLength() {
        if (result_tv.getText().length() > 5) {
            result_tv.setTextSize(50);
        } else {
            result_tv.setTextSize(90);
        }
    }
    private void clearCalculator() {
        rtvText.setLength(0);
        savedNum = "";
        savedOperator = "";
        result_tv.setText("");
        top_tv.setText("");
    }

}