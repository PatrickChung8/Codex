package com.sp.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText Weight;
    private EditText Height;
    private Button buttonCalculate;
    private TextView bmiOutput;
    double weightNumber;
    double heightNumber;
    double bmiNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Weight = findViewById(R.id.weight);
        Height = findViewById(R.id.height);
        buttonCalculate = findViewById(R.id.button);
        buttonCalculate.setOnClickListener(onClick);
        bmiOutput = findViewById(R.id.bmiDisplay);
    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String weightStr = Weight.getText().toString();
            String heightStr = Height.getText().toString();
            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                double weightNumber = Double.parseDouble(weightStr);
                double heightNumber = Double.parseDouble(heightStr);
                double bmiNumber = weightNumber / (heightNumber * heightNumber);
                String bmiStr = String.format("%.2f", bmiNumber);
                if (bmiNumber < 18.5) bmiOutput.setText("BMI - " + bmiStr + " Underweight");
                else if (bmiNumber >= 18.5 && bmiNumber <= 24.9) bmiOutput.setText("BMI - " + bmiStr + " Normal");
                else if (bmiNumber >= 25.0 && bmiNumber <= 29.9) bmiOutput.setText("BMI - " + bmiStr + " Overweight");
                else bmiOutput.setText("BMI - " + bmiStr + " Obese");
            }
            else bmiOutput.setText("Please input the values");
        }
    };
}