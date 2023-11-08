package com.example.assignment1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private TextView historyTextView;
    private Calculator calculator; // Include Calculator object
    private boolean isAdvancedMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        historyTextView = findViewById(R.id.historyTextView);
        calculator = new Calculator(); // Initialize Calculator object
    }

    public void onDigitButtonClick(View view) {
        String digit = ((TextView) view).getText().toString();
        calculator.push(digit); // Call the push method from Calculator
        updateDisplay();
    }

    public void onOperatorClick(View view) {
        String operator = ((TextView) view).getText().toString();
        calculator.push(operator); // Call the push method from Calculator
        updateDisplay();
    }

    @SuppressLint("SetTextI18n")
    public void onEqualsClick(View view) {
        int result = calculator.calculate(); // Calculate the result
        String operationHistory = calculator.getDisplayOperation();
        display.setText(operationHistory + " = " + result); // Update the display with the sequence and result

        if (isAdvancedMode) {
            historyTextView.append("\n" + operationHistory + " = " + result); // Append the operation history
        }
    }

    public void onClearClick(View view) {
        calculator.clear(); // Clear the Calculator's data
        display.setText("0");
    }

    public void onAdvanceButtonClick(View view) {
        isAdvancedMode = !isAdvancedMode;

        if (isAdvancedMode) {
            ((TextView) view).setText(R.string.standard_mode);
            historyTextView.setVisibility(View.VISIBLE);
            historyTextView.setText("History:");
        } else {
            ((TextView) view).setText(R.string.advanced_mode);
            historyTextView.setVisibility(View.GONE);
            historyTextView.setText("");
        }
    }

    private void updateDisplay() {
        if (isAdvancedMode) {
            display.setText(calculator.getDisplayOperation());
        } else {
            if (!calculator.getDisplayOperation().isEmpty()) {
                display.setText(calculator.getDisplayOperation());
            } else {
                display.setText("0");
            }
        }
    }
}