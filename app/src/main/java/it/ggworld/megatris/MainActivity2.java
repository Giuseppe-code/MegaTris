package it.ggworld.megatris;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.ProgressBar;




public class MainActivity2 extends AppCompatActivity {

    ProgressBar androidProgressBar;
    int progressStatusCounter = 0;

    Handler progressHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        androidProgressBar = findViewById(R.id.pb1);


        //Start progressing
        new Thread(() -> {
            while (progressStatusCounter < 10) {
                progressStatusCounter += 2;
                progressHandler.post(() -> {
                    androidProgressBar.setProgress(progressStatusCounter);
                    //Status update in textview
                  //  textView.setText("Status: " + progressStatusCounter + "/" + androidProgressBar.getMax());
                });
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (progressStatusCounter == 10){
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }


        }).start();


    }

}





