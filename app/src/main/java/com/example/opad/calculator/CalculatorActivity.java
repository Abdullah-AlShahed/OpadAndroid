package com.example.opad.calculator;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

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
    Button equalbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result_tv = findViewById(R.id.tv_result_view);
        equalbtn = findViewById(R.id.btn9_2);
        equalbtn.setTag(0);

        top_tv = findViewById(R.id.tv_top_small);

    }

    //2nd Way to make actions with the button
    public void onDigitClick(View view) {
        if (equalbtn.getTag().equals(1)) {
            clearCalculator();
        }
        Button clicked = (Button) view;
        String clickedText = clicked.getText().toString();
        if (clicked.getText().equals(".")) {
            if (result_tv.getText().toString().contains(".")) {
                return;
            }
        }
        checkDigitLength();

        result_tv.append(clickedText);
        top_tv.append(clickedText);
        result_tv.setTag(0);
        equalbtn.setTag(0);

    }

    String savedNum = "";
    String savedOperator = "";
    String lastNum = "";

    public void onOperatorClick(View view) {
        Button clickedOperator = (Button) view;
        String clickedOperatorText = clickedOperator.getText().toString();
        if (!result_tv.getText().toString().isEmpty()) {

            if(clickedOperatorText.equals("SR")||clickedOperatorText.equals("^2")){
                savedNum = result_tv.getText().toString();
                savedOperator = clickedOperatorText;
                calcSRandPowTwo(savedNum,savedOperator);
            }
            else if (savedOperator.isEmpty()) {
                savedNum = result_tv.getText().toString();
                savedOperator = clickedOperatorText;
                result_tv.setText("");
                top_tv.append(" " + savedOperator + " ");
            } else {
                lastNum = result_tv.getText().toString();
                savedNum = calc(savedNum, savedOperator, lastNum);
                result_tv.setText(savedNum);
                savedOperator = clickedOperatorText;
                result_tv.setText("");
                top_tv.setText(savedNum + " " + savedOperator + " ");
            }
            equalbtn.setTag(0);
            result_tv.setTag(0);
        }

    }


    private String calc(String savedNum, String savedOperator, String lastNum) {
        double num1 = Double.parseDouble(savedNum);
        double num2 = Double.parseDouble(lastNum);
        double result = 0.0;

        if (savedOperator.equals("+")) {
            result = num1 + num2;
        } else if (savedOperator.equals("-")) {
            result = num1 - num2;
        } else if (savedOperator.equals("x")) {
            result = (double) Math.multiplyExact((long) num1, (long) num2);
        } else if (savedOperator.equals("/")) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                clearCalculator();
                result_tv.setText("Error: Division by zero");
                return "";
            }
        }
        return "" + result;
    }
    private void calcSRandPowTwo(String savedNum, String savedOperator) {
        double num1 = Double.parseDouble(savedNum);
        double result = 0.0;
        if (savedOperator.equals("SR")) {
            if (num1 >= 0) {
                result = Math.sqrt(num1);
                result_tv.setText(String.valueOf(result));
                checkDigitLength();
                result_tv.setTag("sr");
            } else {
                clearCalculator();
                result_tv.setText("Error: Invalid input for square root");
            }
        } else if (savedOperator.equals("^2")) {
            result = Math.pow(num1, 2);
            result_tv.setText(String.valueOf(result));
            result_tv.setTag("^2");
            checkDigitLength();
          //  Log.d(TAG, "calc() called with: savedNum = [" + savedNum + "], savedOperator = [" + savedOperator + "], lastNum = [" + lastNum + "], Result = [" + result + "]");
        }
    }

    public void onEqualClick(View view) {
        if (!result_tv.getText().toString().isEmpty()) {
            if(result_tv.getTag().equals("sr")||result_tv.getTag().equals("^2")){
                return;
            }
            if(savedOperator.isEmpty()){
                return;
            }
            equalbtn.setTag(1);
            Button clicked = (Button) view;
            String clickedText = clicked.getText().toString();
            lastNum = result_tv.getText().toString();
            savedNum = calc(savedNum, savedOperator, lastNum);
            result_tv.setText(savedNum);
        }
    }

    //****************************************************************
    public void onDeleteClick(View view) {
        String rtv = result_tv.getText().toString();
        if (rtv.length() > 0) {
            result_tv.setText(rtv.subSequence(0, rtv.length() - 1).toString());
            top_tv.setText(result_tv.getText());
            Log.d(TAG, "rtv=" + rtv);
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
        savedNum = "";
        lastNum = "";
        savedOperator = "";
        result_tv.setText("");
        top_tv.setText("");
        equalbtn.setTag(0);
        result_tv.setTag(0);
    }

}