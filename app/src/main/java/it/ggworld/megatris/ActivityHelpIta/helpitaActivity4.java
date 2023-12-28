package it.ggworld.megatris.ActivityHelpIta;

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


public class helpitaActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita4);
        ImageButton button = findViewById(R.id.next34);
        ImageButton pre = findViewById(R.id.previous);
        TextView t = findViewById(R.id.t2);

        Spannable word = new SpannableString("mettiamo caso che il giocatore metta la ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("x ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("in ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("basso a sinistra ");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString("...");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);

        pre.setOnClickListener((View view) -> {
            Intent intent = new Intent(helpitaActivity4.this, helpitaActivity3.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);          });

        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity4.this,helpitaActivity5.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);      });

    }
}