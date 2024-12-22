package com.example.financemanagement;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.financemanagement.R;

public class AnalyticsActivity extends AppCompatActivity {

    private TextView tvTotalExpenses, tvTotalInvestments, tvExpenseDetails, tvInvestmentDetails;
    private Button btnUpdateAnalytics;
    private PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        // Initialize the TextViews
        tvTotalExpenses = findViewById(R.id.tvTotalExpenses);
        tvTotalInvestments = findViewById(R.id.tvTotalInvestments);
        tvExpenseDetails = findViewById(R.id.tvExpenseDetails);
        tvInvestmentDetails = findViewById(R.id.tvInvestmentDetails);
        btnUpdateAnalytics = findViewById(R.id.btnUpdateAnalytics);
        pieChartView = findViewById(R.id.pieChart);

        // Example Totals, calculate based on actual data (replace with real calculations)
        tvTotalExpenses.setText("Total Expenses: $30,000");
        tvTotalInvestments.setText("Total Investments: $50,000");

        // Example Breakdown for expenses and investments
        tvExpenseDetails.setText("Rent: $12,000\nGroceries: $5,000\nUtilities: $3,000\nOthers: $10,000");
        tvInvestmentDetails.setText("Stocks: $25,000\nBonds: $15,000\nReal Estate: $10,000");

        // Initialize Pie Chart with sample data
        pieChartView.setData(30, 50); // 30% Expenses, 50% Investments

        // Refresh Analytics Button
        btnUpdateAnalytics.setOnClickListener(v -> {
            Toast.makeText(AnalyticsActivity.this, "Analytics Updated", Toast.LENGTH_SHORT).show();
        });
    }
}