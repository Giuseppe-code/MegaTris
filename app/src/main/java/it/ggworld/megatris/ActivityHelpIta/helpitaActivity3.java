package it.ggworld.megatris.ActivityHelpIta;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import it.ggworld.megatris.R;


public class helpitaActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita3);
        ImageButton buttonn = findViewById(R.id.next22);
        ImageButton pre = findViewById(R.id.previous22);
        TextView t =findViewById(R.id.t1);



        Spannable word = new SpannableString("in ogni ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("sezione ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("della ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("tabella ");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString("c'è un'altra ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordf = new SpannableString("tabella ");
        wordf.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordf.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordf);

        pre.setOnClickListener((View view) -> {
            Intent intent = new Intent(helpitaActivity3.this, helpitaActivity2.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        });

        buttonn.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity3.this,helpitaActivity4.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        ImageView primo = findViewById(R.id.bc1);
        ImageView secondo = findViewById(R.id.bc2);
        ImageView terzo = findViewById(R.id.bc3);
        ImageView quarto = findViewById(R.id.bc4);
        ImageView quinto = findViewById(R.id.bc5);
        ImageView sesto = findViewById(R.id.bc6);
        ImageView settimo = findViewById(R.id.bc7);
        ImageView ottavo = findViewById(R.id.bc8);
        ImageView nono = findViewById(R.id.bc9);


        int tempo=200;



        ValueAnimator uno = ObjectAnimator.ofFloat(primo, "alpha", 0f, 1f);
        uno.setDuration(tempo);

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


        ValueAnimator unor = ObjectAnimator.ofFloat(primo, "alpha", 1f, 0f);
        unor.setDuration(tempo);

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
        //animazione random
        clipsr.play(unor).before(uno);
        clipsr.play(uno).before(duer);
        clipsr.play(duer).before(due);
        clipsr.play(due).before(trer);
        clipsr.play(trer).before(tre);

        clipsr.play(tre).before(quattror);
        clipsr.play(quattror).before(quattro);
        clipsr.play(quattro).before(cinquer);
        clipsr.play(cinquer).before(cinque);
        clipsr.play(cinque).before(seir);


        clipsr.play(seir).before(sei);
        clipsr.play(sei).before(setter);
        clipsr.play(setter).before(sette);
        clipsr.play(sette).before(ottor);
        clipsr.play(ottor).before(otto);
        clipsr.play(otto).before(nover);
        clipsr.play(nover).before(nove);


        clipsr.start();


    }
}