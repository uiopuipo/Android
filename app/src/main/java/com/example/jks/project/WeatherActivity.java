package com.example.jks.project;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

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
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //---------------WEBVIEW-------------------//
        WebView webView = (WebView)findViewById(R.id.WwebView1);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.kma.go.kr/m/observation/observation_01.jsp");
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        //---------------RADIO_BUTTON-------------------//
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.WradioGroup1);
        final EditText editText = (EditText)findViewById(R.id.WeditText1);

        //---------------BUTTON-------------------//
        Button button = (Button)findViewById(R.id.Wbutton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                String string1 = radioButton.getText().toString();
                String string2 = editText.getText().toString();
                Toast.makeText(WeatherActivity.this, string1, Toast.LENGTH_SHORT);
                Toast.makeText(WeatherActivity.this, string2, Toast.LENGTH_SHORT);
                intent.putExtra("WEATHER_DATA1", string1);
                intent.putExtra("WEATHER_DATA2", string2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
