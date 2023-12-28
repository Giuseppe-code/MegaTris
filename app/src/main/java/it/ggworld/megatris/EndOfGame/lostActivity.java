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


public class lostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        ImageView o = findViewById(R.id.lostp);
        final TextView t = findViewById(R.id.haivintoo);
        Button homelost = findViewById(R.id.winhomeolost);
        Button rigiocalost = findViewById(R.id.winplayolost);


        homelost.setOnClickListener((View view) -> {
            Intent intent = new Intent(lostActivity.this, MainActivity.class);
            startActivity(intent);
        });

        rigiocalost.setOnClickListener((View view) -> {
            Intent intent = new Intent(lostActivity.this, playActivity.class);
            startActivity(intent);
        });

        final float endSize = 60;
        final int animationDuration = 2000;

        ValueAnimator animator = ObjectAnimator.ofFloat(t, "textSize", endSize);
        animator.setDuration(animationDuration);

        animator.start();

        ObjectAnimator anim = ObjectAnimator.ofFloat(o, "scaleX", 0.5f);
        anim.setDuration(2000);
        anim.start();
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(o, "scaleY", 0.5f);
        anim2.setDuration(2000);
        anim2.start();

    }
}





