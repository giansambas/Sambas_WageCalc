package com.example.sambas_wagecalc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etHoursWorked;
    private EditText etHourlyWage;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoursWorked = findViewById(R.id.etHoursWorked);
        etHourlyWage = findViewById(R.id.etHourlyWage);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String hoursWorkedStr = etHoursWorked.getText().toString();
            String hourlyWageStr = etHourlyWage.getText().toString();

            Double hoursWorked = tryParseDouble(hoursWorkedStr);
            Double hourlyWage = tryParseDouble(hourlyWageStr);

            if (hoursWorked != null && hourlyWage != null) {
                double totalWage = hoursWorked * hourlyWage;
                tvResult.setText(String.format("Total Wage: $%.2f", totalWage));
            } else {
                tvResult.setText("Please enter valid numbers");
            }
        });
    }

    private Double tryParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
