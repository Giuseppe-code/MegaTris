package it.ggworld.megatris;



import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;

import android.content.Intent;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



public class playerorbotActivity extends AppCompatActivity {
    private int gameChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerorbot);
        ImageButton play =findViewById(R.id.pvp);
        ImageButton play2 =findViewById(R.id.pvpc);
        Button play3 =findViewById(R.id.indietro);
        ImageView logo =findViewById(R.id.logoplay);


        //indietro
        play3.setOnClickListener((View view)->{
            Intent intent = new Intent(playerorbotActivity.this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        //player
        play.setOnClickListener((View view)->{
            Intent intent = new Intent(playerorbotActivity.this, playActivity.class);
            gameChoose= 0;
            intent.putExtra("key",gameChoose);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        play2.setOnClickListener((View view)->{
            Intent intent = new Intent(playerorbotActivity.this, playActivity.class);
            gameChoose= 1;
            intent.putExtra("key",gameChoose);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });



        //sistema cordinate di partenza con display metrics anche le size





        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height_ = displayMetrics.heightPixels;
        int width_ = displayMetrics.widthPixels;

        float translationY = height_ *- 0.1f;
        float translationX;
        float translationX2;
        float translationY2 = height_ * 0.08f;


        ViewGroup.LayoutParams params = play.getLayoutParams();


        float target2=  params.width *0.5f;
        float target= width_ * 0.5f -target2;
        translationX= target;
        target= width_ *0.5f -target2;
        translationX2= -target  ;

        ObjectAnimator a = ObjectAnimator.ofFloat(logo, "translationY", translationY );
        a.setDuration(1000);
        a.start();

        ObjectAnimator b = ObjectAnimator.ofFloat(play, "translationX", translationX2 );
        b.setDuration(1000);
        b.start();

        ObjectAnimator c = ObjectAnimator.ofFloat(play2, "translationX", translationX );
        c.setDuration(1000);
        c.start();

        ObjectAnimator d = ObjectAnimator.ofFloat(play3, "translationY", translationY2 );
        d.setDuration(1000);
        d.start();


    }
}