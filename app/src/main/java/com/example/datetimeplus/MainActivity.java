package com.example.datetimeplus;

import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText resultValue;
    private TextView outputResultText;
    private LinearLayout resultLayout;
    private RadioGroup timeUnitRadioGroup;

    private int CurrentTimeUnit = Calendar.MONTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_land);
        } else {
            setContentView(R.layout.activity_main);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultValue = findViewById(R.id.AddValueTextInput);
        outputResultText = findViewById(R.id.resultTextOutput);
        resultLayout = findViewById(R.id.ResultScrollViewLinearLayout);
        timeUnitRadioGroup = findViewById(R.id.TimeUnitRadioGroup);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString("outputResultText", outputResultText.getText().toString());
        savedInstanceState.putString("resultValue", resultValue.getText().toString());
        savedInstanceState.putInt("timeUnitRadioGroup", timeUnitRadioGroup.getCheckedRadioButtonId());
        int historyTextCount = resultLayout.getChildCount();
        String[] resultHistory = new String[historyTextCount];
        for (int i = 0; i < historyTextCount; i++)
        {
            TextView child = (TextView) resultLayout.getChildAt(i);
            resultHistory[i] = child.getText().toString();
        }
        savedInstanceState.putStringArray("resultHistory", resultHistory);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        
        outputResultText.setText(savedInstanceState.getString("outputResultText"));
        resultValue.setText(savedInstanceState.getString("resultValue"));
        timeUnitRadioGroup.check(savedInstanceState.getInt("timeUnitRadioGroup"));
        String[] resultHistory = savedInstanceState.getStringArray("resultHistory");
        if (resultHistory != null)
            for (String history : resultHistory)
            {
                addHistoryText(history);
            }
    }

    private void addHistoryText(String history) {
        TextView newResultHistoryText = new TextView(this);
        newResultHistoryText.setTextSize(18);
        newResultHistoryText.setText(history);
        resultLayout.addView(newResultHistoryText);
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

    private String getTimeUnit()
    {
        switch (CurrentTimeUnit)
        {
            case Calendar.HOUR:
                return "Hour";
            case Calendar.DAY_OF_YEAR:
                return "Day";
            case Calendar.WEEK_OF_YEAR:
                return "Week";
            case Calendar.MONTH:
                return "Month";
        }
        return "";
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

        String newString = "+" + value_string + " " + getTimeUnit() + ": " + cal.getTime().toString();
        addHistoryText(newString);
    }

    public void ClearButton(View v)
    {
        resultLayout.removeAllViews();
    }
}