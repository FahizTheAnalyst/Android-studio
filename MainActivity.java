package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonDot, buttonC, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEql;
    TextView result;
    float mValueOne, mValueTwo;
    boolean addition, subtract, multiplication, division;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect UI
        result = findViewById(R.id.tvDisplay);  // Make sure your XML TextView has id 'tvDisplay'
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonDot = findViewById(R.id.btnDot);
        buttonAdd = findViewById(R.id.btnPlus);
        buttonSub = findViewById(R.id.btnMinus);
        buttonMul = findViewById(R.id.btnMultiply);
        buttonDiv = findViewById(R.id.btnDivide);
        buttonEql = findViewById(R.id.btnEquals);
        buttonC = findViewById(R.id.btnClear);

        // Digit buttons
        View.OnClickListener numberClickListener = v -> {
            Button b = (Button) v;
            result.setText(result.getText().toString() + b.getText().toString());
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);
        buttonDot.setOnClickListener(numberClickListener);

        // Clear button
        buttonC.setOnClickListener(v -> result.setText(""));

        // Operation buttons
        buttonAdd.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                addition = true;
                result.setText("");
            }
        });

        buttonSub.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                subtract = true;
                result.setText("");
            }
        });

        buttonMul.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                multiplication = true;
                result.setText("");
            }
        });

        buttonDiv.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                division = true;
                result.setText("");
            }
        });

        // Equal button
        buttonEql.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueTwo = Float.parseFloat(result.getText().toString());

                if (addition) {
                    result.setText(String.valueOf(mValueOne + mValueTwo));
                    addition = false;
                } else if (subtract) {
                    result.setText(String.valueOf(mValueOne - mValueTwo));
                    subtract = false;
                } else if (multiplication) {
                    result.setText(String.valueOf(mValueOne * mValueTwo));
                    multiplication = false;
                } else if (division) {
                    if (mValueTwo == 0) {
                        result.setText("Error");
                    } else {
                        result.setText(String.valueOf(mValueOne / mValueTwo));
                    }
                    division = false;
                }
            }
        });
    }
}
