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


public class helpitaActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita7);
        ImageButton button = findViewById(R.id.next88);
        ImageButton pre = findViewById(R.id.previous88);
        TextView t = findViewById(R.id.t5);

        Spannable word = new SpannableString("facendo ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("tris ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("nella ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("tabella piccola");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString(", conquisti ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordfiv = new SpannableString("la casella");
        wordfiv.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfiv.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfiv);

        pre.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity7.this,helpitaActivity6.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);        });
        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity7.this,helpitaActivity8.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);      });
    }
}