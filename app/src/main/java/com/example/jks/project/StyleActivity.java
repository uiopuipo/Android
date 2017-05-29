package com.example.jks.project;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
MainActivity에서 넘겨받은 값에 해당하는 스타일 이미지를 출력한다.
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
    }
}
