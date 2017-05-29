package com.example.jks.project;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
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
*/ /*------------------------------------------------------*/
public class WeatherActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    RadioGroup radioGroup;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
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
        radioGroup = (RadioGroup)findViewById(R.id.WradioGroup1);
        radioGroup.check(R.id.WradioButton1);
        editText = (EditText)findViewById(R.id.WeditText1);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()) {
            case R.id.Wbutton1:
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                if (editText.getText().toString().equals("")) {
                    finish();
                }else {
                    String string1 = radioButton.getText().toString();
                    String string2 = editText.getText().toString();
                    intent.putExtra("WEATHER_DATA1", string1);
                    intent.putExtra("WEATHER_DATA2", string2);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        }
    }
}
