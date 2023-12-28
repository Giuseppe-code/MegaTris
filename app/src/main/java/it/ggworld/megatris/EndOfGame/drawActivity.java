package it.ggworld.megatris.EndOfGame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import it.ggworld.megatris.MainActivity;
import it.ggworld.megatris.R;
import it.ggworld.megatris.playActivity;


public class drawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("pareggio", "dentro endgame4");
        setContentView(R.layout.activity_pareggio);
        ImageView cerchio = findViewById(R.id.drawo);
        ImageView croce = findViewById(R.id.drawx);
        Button home = findViewById(R.id.winhome);
        TextView tempoG= findViewById(R.id.tempoG);
        TextView pareggio= findViewById(R.id.pareggio);
        Button rigioca = findViewById(R.id.winplay);
        Bundle extras = getIntent().getExtras();
        String time = extras.getString("key");
        tempoG.setText(time);
        Log.i("pareggio", "dentro endgame 5");

        home.setOnClickListener((View view)->{
            Intent intent = new Intent(drawActivity.this, MainActivity.class);
            startActivity(intent);
        });

        rigioca.setOnClickListener((View view)->{
            Intent intent = new Intent(drawActivity.this, playActivity.class);
            startActivity(intent);
        });



        final float endSize = 80;
        final int animationDuration = 2000;

        ValueAnimator animator = ObjectAnimator.ofFloat(pareggio, "textSize", endSize);
        animator.setDuration(animationDuration);

        animator.start();

        ObjectAnimator anim = ObjectAnimator.ofFloat(croce,"scaleX",0.5f);
        anim.setDuration(2000);
        anim.start();
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(croce,"scaleY",0.5f);
        anim2.setDuration(2000);
        anim2.start();
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(cerchio,"scaleX",0.5f);
        anim3.setDuration(2000);
        anim3.start();
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(cerchio,"scaleY",0.5f);
        anim4.setDuration(2000);
        anim4.start();
    }
}