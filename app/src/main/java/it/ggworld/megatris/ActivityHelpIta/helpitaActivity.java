package it.ggworld.megatris.ActivityHelpIta;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;

import it.ggworld.megatris.R;


public class helpitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita);

        ImageButton next = findViewById(R.id.next);

        ImageView secondo = findViewById(R.id.ooo);
        ImageView terzo = findViewById(R.id.oooo);
        ImageView quarto = findViewById(R.id.xxxxxx);
        ImageView quinto = findViewById(R.id.ooooooo);
        ImageView sesto = findViewById(R.id.oooooo);
        ImageView settimo = findViewById(R.id.xxxxx);
        ImageView ottavo = findViewById(R.id.xxxx);
        ImageView nono = findViewById(R.id.ooooo);



        next.setOnClickListener((View view) -> {
            Intent intent = new Intent(helpitaActivity.this, helpitaActivity2.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        int tempo = 200;


        ValueAnimator due = ObjectAnimator.ofFloat(secondo, "alpha", 0f, 1f);
        due.setDuration(tempo);

        ValueAnimator tre = ObjectAnimator.ofFloat(terzo, "alpha", 0f, 1f);
        tre.setDuration(tempo);

        ValueAnimator quattro = ObjectAnimator.ofFloat(quarto, "alpha", 0f, 1f);
        quattro.setDuration(tempo);

        ValueAnimator cinque = ObjectAnimator.ofFloat(quinto, "alpha", 0f, 1f);
        cinque.setDuration(tempo);

        ValueAnimator sei = ObjectAnimator.ofFloat(sesto, "alpha", 0f, 1f);
        sei.setDuration(tempo);

        ValueAnimator sette = ObjectAnimator.ofFloat(settimo, "alpha", 0f, 1f);
        sette.setDuration(tempo);

        ValueAnimator otto = ObjectAnimator.ofFloat(ottavo, "alpha", 0f, 1f);
        otto.setDuration(tempo);

        ValueAnimator nove = ObjectAnimator.ofFloat(nono, "alpha", 0f, 1f);
        nove.setDuration(tempo);


//secondo gruppo




        ValueAnimator duer = ObjectAnimator.ofFloat(secondo, "alpha", 1f, 0f);
        duer.setDuration(tempo);

        ValueAnimator trer = ObjectAnimator.ofFloat(terzo, "alpha", 1f, 0f);
        trer.setDuration(tempo);

        ValueAnimator quattror = ObjectAnimator.ofFloat(quarto, "alpha", 1f, 0f);
        quattror.setDuration(tempo);

        ValueAnimator cinquer = ObjectAnimator.ofFloat(quinto, "alpha", 1f, 0f);
        cinquer.setDuration(tempo);

        ValueAnimator seir = ObjectAnimator.ofFloat(sesto, "alpha", 1f, 0f);
        seir.setDuration(tempo);

        ValueAnimator setter = ObjectAnimator.ofFloat(settimo, "alpha", 1f, 0f);
        setter.setDuration(tempo);

        ValueAnimator ottor = ObjectAnimator.ofFloat(ottavo, "alpha", 1f, 0f);
        ottor.setDuration(tempo);

        ValueAnimator nover = ObjectAnimator.ofFloat(nono, "alpha", 1f, 0f);
        nover.setDuration(tempo);


        AnimatorSet clipsr = new AnimatorSet();


        //spirale
        clipsr.play(seir).before(duer);
        clipsr.play(duer).before(sei);
        clipsr.play(sei).before(ottor);
        clipsr.play(ottor).before(due);
        clipsr.play(due).before(cinquer);
        clipsr.play(cinquer).before(otto);
        clipsr.play(otto).before(setter);
        clipsr.play(setter).before(cinque);
        clipsr.play(cinque).before(trer);
        clipsr.play(trer).before(sette);
        clipsr.play(sette).before(nover);
        clipsr.play(nover).before(tre);
        clipsr.play(tre).before(quattror);
        clipsr.play(quattror).before(nove);
        clipsr.play(nove).before(quattro);
        clipsr.start();



        clipsr.start();

    }
}