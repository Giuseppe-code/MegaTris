package it.ggworld.megatris.EndOfGame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import it.ggworld.megatris.MainActivity;
import it.ggworld.megatris.R;
import it.ggworld.megatris.playActivity;


public class winX extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_x);
        final TextView tv = findViewById(R.id.haivintox);
        ImageView x = findViewById(R.id.xx);
        Button home = findViewById(R.id.winhome);
        TextView tempoG= findViewById(R.id.tempoG);
        Button rigioca = findViewById(R.id.winplay);
        Bundle extras = getIntent().getExtras();
        String time = extras.getString("key");

        tempoG.setText(time);
        home.setOnClickListener((View view)->{
            Intent intent = new Intent(winX.this, MainActivity.class);
            startActivity(intent);
        });

        rigioca.setOnClickListener((View view)->{
            Intent intent = new Intent(winX.this, playActivity.class);
            startActivity(intent);
        });



        final float endSize = 80;
        final int animationDuration = 2000;

        ValueAnimator animator = ObjectAnimator.ofFloat(tv, "textSize", endSize);
        animator.setDuration(animationDuration);

        animator.start();

        ObjectAnimator anim = ObjectAnimator.ofFloat(x,"scaleX",0.5f);
        anim.setDuration(2000);
        anim.start();
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(x,"scaleY",0.5f);
        anim2.setDuration(2000);
        anim2.start();






    }
}