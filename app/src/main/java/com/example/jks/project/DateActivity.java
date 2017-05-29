package com.example.jks.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
날짜를 표시하는 액티비티
날짜를 선택하면 edittext에 값을 저장하고
버튼을 누르면 edittext의 값을 인텐트로 넘기며
액티비티를 종료합니다.
*/ /*------------------------------------------------------*/

public class DateActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        final EditText editText = (EditText) findViewById(R.id.DeditText1);
        Button button = (Button) findViewById(R.id.Dbutton1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("DATE_DATA1", editText.getText().toString());
                intent.putExtra("DATE_DATA2",mMonth+1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        CalendarView calendarView = (CalendarView) findViewById(R.id.DcalendarView1);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mYear = year;
                mMonth = month;
                mDay = dayOfMonth;
                editText.setText(""+mYear+"년 "+(mMonth+1)+"월 "+mDay+"일");
            }
        });
    }
}

