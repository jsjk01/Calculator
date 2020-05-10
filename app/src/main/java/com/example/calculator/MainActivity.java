package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,btnAdd,btnSub,btnMul,btnDiv,btnClr,btnDot,btnEql,btnDelete,btnOpenBracket,btnCloseBracket;
    TextView input,output;
    String exp, emp="";
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.num0);
        b1 = findViewById(R.id.num1);
        b2 = findViewById(R.id.num2);
        b3 = findViewById(R.id.num3);
        b4 = findViewById(R.id.num4);
        b5 = findViewById(R.id.num5);
        b6 = findViewById(R.id.num6);
        b7 = findViewById(R.id.num7);
        b8 = findViewById(R.id.num8);
        b9 = findViewById(R.id.num9);
        btnDot = findViewById(R.id.dot);
        btnAdd = findViewById(R.id.addition);
        btnSub = findViewById(R.id.subtract);
        btnMul = findViewById(R.id.multiply);
        btnDiv = findViewById(R.id.division);
        btnClr = findViewById(R.id.clear);
        btnOpenBracket = findViewById(R.id.openBracket);
        btnCloseBracket = findViewById(R.id.closeBracket);
        btnEql = findViewById(R.id.equal);
        btnDelete = findViewById(R.id.delete);
        input = findViewById(R.id.data);
        output = findViewById(R.id.answer);

        /* setOnclick();*/
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp=emp;
                input.setText(exp);
                output.setText(exp);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "/");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + ".");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(exp.substring(0, exp.length()));
            }
        });
        btnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + "(");
            }
        });
        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();
                input.setText(exp + ")");
            }
        });
        btnEql.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                exp = input.getText().toString();

                // Create an Expression (A class from exp4j library)
                try {
                    Expression expression = new ExpressionBuilder(exp).build();
                    // Calculate the result and display
                    double result = expression.evaluate();
                    output.setText(Double.toString(result));
                } catch (ArithmeticException ex) {
                    // Display an error message
                    output.setText("Error");
                } catch (Exception e){
                    output.setText("Error");
                }
            }
        });
    }
}

