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


public class winO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_o);
        ImageView o = findViewById(R.id.oo);
       final TextView t = findViewById(R.id.haivintoo);
        Bundle extras = getIntent().getExtras();
        TextView tempoG= findViewById(R.id.tempoG);
        String time = extras.getString("key");
        Button home = findViewById(R.id.winhomeo);
        Button rigioca = findViewById(R.id.winplayo);
        tempoG.setText(time);

        home.setOnClickListener((View view)->{
            Intent intent = new Intent(winO.this, MainActivity.class);
            startActivity(intent);
        });

        rigioca.setOnClickListener((View view)->{
            Intent intent = new Intent(winO.this, playActivity.class);
            startActivity(intent);
        });




        final float endSize = 80;
        final int animationDuration = 2000;

        ValueAnimator animator = ObjectAnimator.ofFloat(t, "textSize", endSize);
        animator.setDuration(animationDuration);

        animator.start();

        ObjectAnimator anim = ObjectAnimator.ofFloat(o,"scaleX",0.5f);
        anim.setDuration(2000);
        anim.start();
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(o,"scaleY",0.5f);
        anim2.setDuration(2000);
        anim2.start();



    }
}