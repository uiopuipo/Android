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
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void PonClick(View view){
        if(isEmpty(editText1) || isEmpty(editText2)) {
            Toast.makeText(getApplicationContext(), "키와 몸무게를 입력하세요."
                    ,Toast.LENGTH_SHORT).show();
        }
        else {
            String height = editText1.getText().toString();
            String weight = editText2.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("PERSONAL_DATA1", height);
            intent.putExtra("PERSONAL_DATA2", weight);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
