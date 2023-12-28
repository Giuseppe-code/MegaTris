package it.ggworld.megatris.ActivityHelpEn;

import androidx.appcompat.app.AppCompatActivity;


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


public class helpActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help5);
        ImageButton button = findViewById(R.id.next);
        ImageButton pre = findViewById(R.id.previous);
        ImageView r = findViewById(R.id.dra);
        TextView t=findViewById(R.id.col4);

        Spannable word = new SpannableString("the ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("opponent ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("will have to play in the ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("lower left ");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString("but of the ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordnin = new SpannableString("main table");
        wordnin.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordnin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordnin);

        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(r, "alpha", 0f, 1f);
        fadeAnim.setDuration(2000);
        fadeAnim.start();
        pre.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity5.this,helpActivity4.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);      });
        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity5.this,helpActivity6.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);       });
    }


    }
