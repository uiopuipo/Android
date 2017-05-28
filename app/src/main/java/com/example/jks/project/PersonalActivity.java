package com.example.jks.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*------프로젝트 공동 작업을 위한 설명 공간입니다.------*/ /*
개인 정보를 입력받는 액티비티
키, 몸무게 -> BMI
*/ /*------------------------------------------------------*/
public class PersonalActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        editText1 = (EditText)findViewById(R.id.PeditText1);
        editText2 = (EditText)findViewById(R.id.PeditText2);
        editText3 = (EditText)findViewById(R.id.PeditText3);
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void PonClick(View view){
        if(isEmpty(editText1) || isEmpty(editText2)) {
            Toast.makeText(getApplicationContext(), "키와 몸무게를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else {
            double height = Double.parseDouble(editText1.getText().toString());
            double weight = Double.parseDouble(editText2.getText().toString());
            double bmi = weight / ((height/100) * (height/100));
            String result=String.format("%.2f",bmi);
            editText3.setText("" + bmi);

            Intent intent = new Intent();
            intent.putExtra("PERSONAL_DATA", result);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
