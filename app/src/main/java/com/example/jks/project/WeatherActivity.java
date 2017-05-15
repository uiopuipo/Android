package com.example.jks.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
웹같은걸로 날짜 보여주고
kma.go.kr/m/observation/observation_01.jsp
날씨는 라디오버튼으로 선택하게 하고
온도도 입력 받고
-10~5도는 옷을 두껍게
5~15도는 약간 두껍게
15~20도는 보통
20~ 얇게
*/ /*------------------------------------------------------*/
public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }
}
