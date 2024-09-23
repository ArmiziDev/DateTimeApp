package com.example.datetimeplus;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText resultValue;
    private TextView outputResultText;
    private int CurrentTimeUnit = Calendar.MONTH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultValue =findViewById(R.id.AddValueTextInput);
        outputResultText = findViewById(R.id.resultTextOutput);
    }

    public void TimeUnitRadioSelection(View v)
    {
        int id = v.getId();
        if (id == R.id.HoursRadioButton) {
            CurrentTimeUnit = Calendar.HOUR;
        } else if (id == R.id.DaysRadioButton) {
            CurrentTimeUnit = Calendar.DAY_OF_YEAR;
        } else if (id == R.id.WeeksRadioButton) {
            CurrentTimeUnit = Calendar.WEEK_OF_YEAR;
        } else if (id == R.id.MonthsRadioButton) {
            CurrentTimeUnit = Calendar.MONTH;
        }
    }

    public void Calculate(View v)
    {
        String value_string = resultValue.getText().toString();
        resultValue.setText("");
        if (value_string.isEmpty())
        {
            return;
        }
        int addAmount = Integer.parseInt(value_string);

        Calendar cal = Calendar.getInstance();
        cal.add(CurrentTimeUnit, addAmount);

        outputResultText.setText(cal.getTime().toString());

        LinearLayout resultLayout = findViewById(R.id.ResultScrollViewLinearLayout);
        TextView newResultHistoryText = new TextView(this);

        newResultHistoryText.setText("+" + value_string + "" + cal.getTime().toString());
        resultLayout.addView(newResultHistoryText);
    }
}