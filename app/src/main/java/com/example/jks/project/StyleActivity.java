package com.example.jks.project;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
MainActivity에서 넘겨받은 값에 해당하는 스타일 이미지를 출력한다.
~5 방한복
5~15 두꺼운 옷
15~22 보통 옷
23~ 얇은 옷
27~ 더 얇은 옷

BMI수치 ~18.5 저체중
18.5~22.9 보통~과체중
23~ 비만

3월~5월 봄
6월~8월 여름
9월~10월 가을
11월~2월 겨울
*/ /*------------------------------------------------------*/

public class StyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Intent intent = getIntent();
        int month= intent.getIntExtra("MAIN_DATA1", 0); // 날짜 -> 계절
        String weather = intent.getStringExtra("MAIN_DATA2"); // 날씨 -> 우산체크
        double temperature = intent.getDoubleExtra("MAIN_DATA3", 0); // 온도 -> 옷의 두께
        double bmi = intent.getDoubleExtra("MAIN_DATA4", 0); // bmi -> 스타일

        ImageView imageView1 = (ImageView) findViewById(R.id.SimageView1);
        imageView1.setImageResource(R.drawable.a);

        switch(weather){
            case "맑음":
                break;
            case "흐림":
                Toast.makeText(this, "우산을 챙기세요!", Toast.LENGTH_LONG).show();
                //우산 메시지
                break;
            case "비":
                Toast.makeText(this, "우산을 챙기세요!", Toast.LENGTH_LONG).show();
                //우산 메시지
                break;
            case "눈":
                Toast.makeText(this, "우산을 챙기세요!", Toast.LENGTH_LONG).show();
                //우산 메시지
                break;
        }
/*
        switch(month){
            case 3:case 4:case 5:
                //봄 옷
                break;
            case 6:case 7:case 8:
                //여름 옷
                break;
            case 9:case 10:
                //가을 옷
                break;
            case 11:case 12:case 1:case 2:
                //겨울 옷
                break;
        }

        if(temperature <= 5){
            //더 두꺼운 옷
        } else if(temperature > 5 || temperature <= 15){
            //두꺼운 옷
        } else if(temperature > 15 || temperature <= 22){
            //보통 옷
        } else if(temperature > 22 || temperature <= 27){
            //얇은 옷
        } else if(temperature > 27){
            //더 얇은 옷
        }

        if(bmi <= 18.5){
            //저체중
        } else if(bmi > 18.5 || temperature <= 22.9){
            //보통
        } else if(temperature > 22.9) {
            //비만
        }
        */
    }
}
