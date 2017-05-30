package com.example.jks.project;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

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

//파일 이름 정하기
//마른 = i , 보통 = s , 비만 = d
//봄, 가을 = a , 여름 = s , 겨울 = w
//끝자리는 랜덤
//마른 사람이 겨울 패션을 추천받는다 -> iw4
*/ /*------------------------------------------------------*/

public class StyleActivity extends AppCompatActivity {
    char a, b = 0;    String c;    int d = 0;
    String filename;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        linearLayout = (LinearLayout)findViewById(R.id.SlinearLayout1);
        linearLayout.setVisibility(View.INVISIBLE);
        fassion(); //받은 정보로 스타일을 결정한다.

        int resId = getResources().getIdentifier(filename, "drawable", "com.example.jks.project"); //파일 이름을 정한다.
        while(resId == 0) { //출력할 파일이 없을 경우
            Random r = new Random();
            d = r.nextInt() % 10 + 1;
            while(d<0)
                d = r.nextInt() % 10 + 1;
            c = String.valueOf(d);
            filename = (""+a+b+c); //다시 정한다.
            resId = getResources().getIdentifier(filename, "drawable", "com.example.jks.project");
        }

        ImageView imageView = (ImageView) findViewById(R.id.SimageView1);
        imageView.setImageResource(resId); //이미지를 출력한다.
    }
    public void fassion(){
        //파일 이름 정하기
        //마른 = i , 보통 = s , 비만 = d
        //봄, 가을 = a , 여름 = s , 겨울 = w
        //끝자리는 랜덤
        //마른 사람이 겨울 패션을 추천받는다 -> iw4

        Intent intent = getIntent();
        int month= intent.getIntExtra("MAIN_DATA1", 0); // 날짜 -> 계절
        String weather = intent.getStringExtra("MAIN_DATA2"); // 날씨 -> 우산체크
        double temperature = intent.getDoubleExtra("MAIN_DATA3", 0); // 온도 -> 옷의 두께
        double bmi = intent.getDoubleExtra("MAIN_DATA4", 0); // bmi -> 스타일

        switch(weather){
            case "맑음":
                linearLayout.setVisibility(View.INVISIBLE);
                break;
            case "흐림":
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case "비":
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case "눈":
                linearLayout.setVisibility(View.VISIBLE);
                break;
        }

        switch(month){
            case 3:case 4:case 5:
                b='a';
                break;
            case 6:case 7:case 8:
                b='s';
                break;
            case 9:case 10:
                b='a';
                break;
            case 11:case 12:case 1:case 2:
                b='w';
                break;
        }

        if(bmi <= 18.5){
            a='i';
        } else if(bmi > 18.5 && bmi <= 22.9){
            a='s';
        } else if(bmi > 22.9) {
            a='d';
        }
        Random r = new Random();
        d = r.nextInt() % 10 + 1;
        while(d<0)
            d = r.nextInt() % 10 + 1;
        c = String.valueOf(d);
        filename = (""+a+b+c);
    }
}
