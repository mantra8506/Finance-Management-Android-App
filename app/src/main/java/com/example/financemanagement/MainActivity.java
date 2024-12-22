package com.example.financemanagement;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.financemanagement.R; // Make sure to import the correct package
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize MaterialCardViews
        MaterialCardView dailyExpensesCard = findViewById(R.id.cardDailyExpenses);
        MaterialCardView investmentsCard = findViewById(R.id.cardInvestments);
        MaterialCardView analyticsCard = findViewById(R.id.cardAnalytics);

        // Set click listeners to open respective activities
        dailyExpensesCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DailyExpensesActivity.class);
            startActivity(intent);
        });

        investmentsCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InvestmentsActivity.class);
            startActivity(intent);
        });

        analyticsCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnalyticsActivity.class);
            startActivity(intent);
        });
    }
}