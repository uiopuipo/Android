package com.example.jks.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------
1. GitHub 주소 : 
2. XML 이름 짓기 규칙 - 추가한 위젯들의 ID는 해당 액티비티의 첫 글자를 앞에 붙이고 숫자를 추가합니다.
ex) MainActivity에서 button으로 기본 생성이 되었다 -> Mbutton1
------------------------------------------------------*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {

    }
}
