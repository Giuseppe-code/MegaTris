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

import it.ggworld.megatris.MainActivity;
import it.ggworld.megatris.R;


public class helpActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help8);
        ImageButton restart = findViewById(R.id.restarttt);
        ImageButton home = findViewById(R.id.homeee);
        TextView t = findViewById(R.id.col7);


        Spannable word = new SpannableString("to ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("win ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("you have to make ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("three of a kind ");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString("in the ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordnin = new SpannableString("main table");
        wordnin.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordnin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordnin);

        restart.setOnClickListener((View view) -> {
            Intent intent = new Intent(helpActivity8.this, helpActivity2.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        });

        home.setOnClickListener((View view) -> {
            Intent intent = new Intent(helpActivity8.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        });

    }
}