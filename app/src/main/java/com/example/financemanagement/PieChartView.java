package com.example.financemanagement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PieChartView extends View {

    private float expensePercentage = 30f;  // Default 30%
    private float investmentPercentage = 50f;  // Default 50%

    private Paint expensePaint;
    private Paint investmentPaint;
    private Paint textPaint;

    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize paints
        expensePaint = new Paint();
        expensePaint.setColor(Color.RED);
        expensePaint.setStyle(Paint.Style.FILL);

        investmentPaint = new Paint();
        investmentPaint.setColor(Color.GREEN);
        investmentPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40f);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setData(float expensePercentage, float investmentPercentage) {
        this.expensePercentage = expensePercentage;
        this.investmentPercentage = investmentPercentage;
        invalidate(); // Redraw the view
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float startAngle = 0f;

        // Draw the expense section
        canvas.drawArc(100, 100, getWidth() - 100, getHeight() - 100, startAngle, expensePercentage * 3.6f, true, expensePaint);
        startAngle += expensePercentage * 3.6f;

        // Draw the investment section
        canvas.drawArc(100, 100, getWidth() - 100, getHeight() - 100, startAngle, investmentPercentage * 3.6f, true, investmentPaint);

        // Draw text in the middle of the pie chart
        canvas.drawText("Analytics", getWidth() / 2, getHeight() / 2, textPaint);
    }
}