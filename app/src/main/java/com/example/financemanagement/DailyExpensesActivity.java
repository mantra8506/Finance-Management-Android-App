package com.example.financemanagement;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.financemanagement.R; // Ensure correct package import

public class DailyExpensesActivity extends AppCompatActivity {

    // Declare UI components
    private EditText expenseNameInput, expenseAmountInput;
    private Button addExpenseButton;
    private TextView expenseListTextView; // To display the data

    // StringBuilder to accumulate data to display
    private StringBuilder expensesListBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_expenses);

        // Initialize UI components
        expenseNameInput = findViewById(R.id.expenseNameInput);
        expenseAmountInput = findViewById(R.id.expenseAmountInput);
        addExpenseButton = findViewById(R.id.addExpenseButton);
        expenseListTextView = findViewById(R.id.expenseListTextView); // Make sure this TextView is in your layout

        // Set onClickListener for the button to add expense
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the data from inputs
                String name = expenseNameInput.getText().toString().trim();
                String amount = expenseAmountInput.getText().toString().trim();

                // Check if inputs are not empty
                if (!name.isEmpty() && !amount.isEmpty()) {
                    // Append the expense to the list
                    expensesListBuilder.append("Expense: ").append(name)
                            .append(", Amount: ").append(amount).append("\n");

                    // Update the TextView to show the expense list
                    expenseListTextView.setText(expensesListBuilder.toString());

                    // Clear the input fields for new entry
                    expenseNameInput.setText("");
                    expenseAmountInput.setText("");
                }
            }
        });
    }
}