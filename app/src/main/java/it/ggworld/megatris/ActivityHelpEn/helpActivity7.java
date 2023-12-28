package it.ggworld.megatris.ActivityHelpEn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import it.ggworld.megatris.R;


public class helpActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help7);
        ImageButton button = findViewById(R.id.next);
        ImageButton pre = findViewById(R.id.previous);
        TextView t=findViewById(R.id.col6);

        Spannable word = new SpannableString("by making ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("three of a kind ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("in the ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("small table ");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString("you conquer ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordnin = new SpannableString("the square");
        wordnin.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordnin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordnin);

        pre.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity7.this,helpActivity6.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpActivity7.this,helpActivity8.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);      });
    }
}