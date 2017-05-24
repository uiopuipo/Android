package com.example.jks.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
1. GitHub 주소 : https://github.com/uiopuipo/Android
2. XML 이름짓기 규칙 - 추가한 위젯들의 ID는 해당 액티비티의 첫 글자를 앞에 붙이고 숫자를 추가합니다.
ex) activity_main에서 button으로 기본 생성이 되었다면 메인의 M을 따서 -> "@+id/Mbutton1"
3. 객체 이름짓기 규칙 - 해당 객체의 종류를 소문자로 적고 숫자를 추가합니다.
ex) Button 객체를 생성한다면 -> Button button1
*/ /*------------------------------------------------------*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static int DATE_CODE = 1;
    EditText editText1, editText2, editText3, editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.MeditText1);
        editText2 = (EditText) findViewById(R.id.MeditText2);
        editText3 = (EditText) findViewById(R.id.MeditText3);
        editText4 = (EditText) findViewById(R.id.MeditText4);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Mbutton1:
                intent = new Intent(MainActivity.this, DateActivity.class);
                startActivityForResult(intent, DATE_CODE);
                break;
            case R.id.Mbutton2:
                intent = new Intent(MainActivity.this, PersonalActivity.class);
                startActivityForResult(intent, RESULT_OK);
                break;
            case R.id.Mbutton3:
                intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivityForResult(intent, RESULT_OK);
                break;
            case R.id.Mbutton4:
                intent = new Intent(MainActivity.this, StyleActivity.class);
                startActivityForResult(intent, RESULT_OK);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == DATE_CODE) {
            if(resultCode == RESULT_OK) {
                editText1.setText(data.getStringExtra("DATE_DATA"));
            }
        }
    }
}
