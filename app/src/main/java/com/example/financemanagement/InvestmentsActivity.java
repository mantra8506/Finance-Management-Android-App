package com.example.financemanagement;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InvestmentsActivity extends AppCompatActivity {

    private ListView lvInvestments;
    private EditText etInvestmentName, etAmount, etReturns, etYears;
    private Spinner spInvestmentType;
    private Button btnAddInvestment, btnCalculateInterest;
    private ArrayList<String> investments = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        // Initialize Views
        lvInvestments = findViewById(R.id.lvInvestments);
        etInvestmentName = findViewById(R.id.etInvestmentName);
        etAmount = findViewById(R.id.etAmount);
        etReturns = findViewById(R.id.etReturns);
        etYears = findViewById(R.id.etYears);
        spInvestmentType = findViewById(R.id.spInvestmentType);
        btnAddInvestment = findViewById(R.id.btnAddInvestment);
        btnCalculateInterest = findViewById(R.id.btnCalculateInterest);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, investments);
        lvInvestments.setAdapter(adapter);

        // Populate Spinner
        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this,
                R.array.investment_types, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spInvestmentType.setAdapter(adapterType);

        // Add Investment Button
        btnAddInvestment.setOnClickListener(v -> {
            String name = etInvestmentName.getText().toString();
            String amount = etAmount.getText().toString();
            String returns = etReturns.getText().toString();
            String type = spInvestmentType.getSelectedItem().toString();

            if (!name.isEmpty() && !amount.isEmpty() && !returns.isEmpty()) {
                investments.add("Name: " + name + ", Type: " + type + ", Amount: " + amount + ", Returns: " + returns + "%");
                adapter.notifyDataSetChanged();
                clearFields();
                hideKeyboard(); // Hide keyboard when adding investment
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Calculate Interest Button
        btnCalculateInterest.setOnClickListener(v -> {
            String amountStr = etAmount.getText().toString();
            String returnsStr = etReturns.getText().toString();
            String yearsStr = etYears.getText().toString();

            if (!amountStr.isEmpty() && !returnsStr.isEmpty() && !yearsStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);
                double annualReturns = Double.parseDouble(returnsStr);
                int years = Integer.parseInt(yearsStr);

                double futureValue = calculateInterest(amount, annualReturns, years);
                Toast.makeText(this, "Future Value: " + futureValue, Toast.LENGTH_SHORT).show();
                hideKeyboard(); // Hide keyboard after calculation
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Hide keyboard when user taps outside the EditText fields
        findViewById(R.id.activity_investments).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
    }

    // Method to calculate the compound interest
    private double calculateInterest(double amount, double returns, int years) {
        return amount * Math.pow((1 + (returns / 100)), years);
    }

    // Utility method to hide the keyboard
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    // Clear input fields after adding investment
    private void clearFields() {
        etInvestmentName.setText("");
        etAmount.setText("");
        etReturns.setText("");
        etYears.setText("");
        spInvestmentType.setSelection(0);
    }
}