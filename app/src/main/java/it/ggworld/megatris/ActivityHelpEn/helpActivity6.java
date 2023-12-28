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


public class helpActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help6);
        ImageButton button = findViewById(R.id.next);
        ImageButton pre = findViewById(R.id.previous);
        ImageView r =findViewById(R.id.dra3);
        TextView t=findViewById(R.id.col5);


        Spannable word = new SpannableString("in other words, ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("your choice ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("will deteminate a part of ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("your opponent's choice");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString(", be smart!");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);





        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(r, "alpha", 0f, 1f);
        fadeAnim.setDuration(2000);
        fadeAnim.start();

        pre.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity6.this,helpActivity5.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);       });
        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity6.this,helpActivity7.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);        });


    }
}