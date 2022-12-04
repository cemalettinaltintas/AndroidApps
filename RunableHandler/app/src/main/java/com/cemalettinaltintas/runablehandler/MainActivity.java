package com.cemalettinaltintas.runablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int number;
    Handler handler;//Runable ele aldığımız bir arayüz (interface)
    Runnable runable;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button =findViewById(R.id.button);
        number = 0;
    }

    public void start(View view) {
        //handler=new Handler(Looper.getMainLooper());
        handler=new Handler();
        runable= new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : " + number);
                number++;
                textView.setText("Time : " + number);
                //Runable belli aralıklarla çalıştırılıyor.
                handler.postDelayed(runable,1000);
            }
        };
        handler.post(runable);
        button.setEnabled(false);


    }

    public void stop(View view) {
        button.setEnabled(true);
        //Arkaplanda çalışan runable kapatılıyor.
        handler.removeCallbacks(runable);
        number=0;
        textView.setText("Time : "+number);
    }
}