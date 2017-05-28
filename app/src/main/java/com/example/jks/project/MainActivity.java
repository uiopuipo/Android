package com.example.jks.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
1. GitHub 주소 : https://github.com/uiopuipo/Android
2. XML 이름짓기 규칙 - 추가한 위젯들의 ID는 해당 액티비티의 첫 글자를 앞에 붙이고 숫자를 추가합니다.
    ex) activity_main에서 button으로 기본 생성이 되었다면 메인의 M을 따서 -> "@+id/Mbutton1"
3. 객체 이름짓기 규칙 - 해당 객체의 종류를 소문자로 적고 숫자를 추가합니다.
    ex) Button 객체를 생성한다면 -> Button button1

    4. 해야하는것 날짜 -> 계절을 판단
                  날씨로 -> 우산을 가져가세요
                  BMI로 스타일을 판단
                  값에다 범위를 준다 -> 디테일
*/ /*------------------------------------------------------*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static int DATE_CODE = 1;
    final static int WEATHER_CODE = 2;
    final static int PERSONAL_CODE = 3;
    final static int STYLE_CODE = 4;
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

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
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
                intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivityForResult(intent, WEATHER_CODE);
                break;
            case R.id.Mbutton3:
                intent = new Intent(MainActivity.this, PersonalActivity.class);
                startActivityForResult(intent, PERSONAL_CODE);
                break;
            case R.id.Mbutton4:
                if(isEmpty(editText1) || isEmpty(editText2) || isEmpty(editText3)) {
                    Toast.makeText(getApplicationContext(), "정보를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                intent = new Intent(MainActivity.this, StyleActivity.class);
                //위의 3개의 결과를 바탕으로 값을 계산해 인텐트로 넘긴다.
                startActivityForResult(intent, STYLE_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == DATE_CODE) {
            if(resultCode == RESULT_OK) {
                editText1.setText(data.getStringExtra("DATE_DATA"));
            }
        }else if(requestCode == WEATHER_CODE) {
            if(resultCode == RESULT_OK) {
                String string1 = data.getStringExtra("WEATHER_DATA1");
                String string2 = data.getStringExtra("WEATHER_DATA2");
                editText2.setText("날씨: " +string1 +", 온도 : "+ string2 +"도");
            }
        }else if(requestCode == PERSONAL_CODE) {
            if(resultCode == RESULT_OK) {
                editText3.setText(data.getStringExtra("PERSONAL_DATA"));
            }
        }else if(requestCode == STYLE_CODE) {
            if(resultCode == RESULT_OK) {
                editText4.setText(data.getStringExtra("STYLE_DATA"));
            }
        }
    }
}
