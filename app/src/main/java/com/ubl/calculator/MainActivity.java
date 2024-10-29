package com.ubl.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber1;
    private EditText txtNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlusButton(v);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMinusButton(v);
            }
        });
    }

    public void handlePlusButton(View view) {
        String number1 = txtNumber1.getText().toString();
        String number2 = txtNumber2.getText().toString();

        if (number1.isEmpty()) {
            Toast.makeText(this, "number 1 is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (number2.isEmpty()) {
            Toast.makeText(this, "number 2 is required", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = Integer.parseInt(number1) + Integer.parseInt(number2);
        showResultDialog("Result", "The result of addition is: " + result);
    }

    public void handleMinusButton(View view) {
        String number1 = txtNumber1.getText().toString();
        String number2 = txtNumber2.getText().toString();

        if (number1.isEmpty()) {
            Toast.makeText(this, "number 1 is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (number2.isEmpty()) {
            Toast.makeText(this, "number 2 is required", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = Integer.parseInt(number1) - Integer.parseInt(number2);
        showResultDialog("Result", "The result of subtraction is: " + result);
    }

    private void showResultDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}