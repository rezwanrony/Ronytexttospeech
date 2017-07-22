package com.example.azer.ronytexttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    private int MY_DATA_CHECK_CODE = 0;
    EditText text;
    Button btn_speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.et_text);
        btn_speak = (Button) findViewById(R.id.btn_speak);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(text.getTextLocale());
                    Toast.makeText(getApplicationContext(),t1.getLanguage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        })      ;

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),t1.getLanguage().toString(),Toast.LENGTH_SHORT).show();
                String speak = text.getText().toString();
                Toast.makeText(getApplicationContext(), speak, Toast.LENGTH_SHORT).show();
                t1.speak(speak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }


        @Override
        protected void onPause () {
            if (t1 != null) {
                t1.stop();
                t1.shutdown();
            }
            super.onPause();
        }
    }
