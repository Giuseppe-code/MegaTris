package it.ggworld.megatris.ActivityHelpIta;

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


public class helpitaActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita5);
        ImageButton button = findViewById(R.id.nextqw);
        ImageButton pre = findViewById(R.id.previousqw);
        ImageView r = findViewById(R.id.dra);
        TextView t = findViewById(R.id.t3);

        Spannable word = new SpannableString("l'");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("avversario ");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);
        Spannable wordTre = new SpannableString("dovrà giocare in ");
        wordTre.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTre.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTre);
        Spannable wordfive = new SpannableString("basso a sinistra");
        wordfive.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfive);
        Spannable wordfor = new SpannableString(", ma della ");
        wordfor.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordfor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfor);
        Spannable wordfiv = new SpannableString("tabella principale");
        wordfiv.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordfiv.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordfiv);



        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(r, "alpha", 0f, 1f);
        fadeAnim.setDuration(2000);
        fadeAnim.start();
        pre.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity5.this,helpitaActivity4.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);      });
        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity5.this,helpitaActivity6.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);       });
    }


}
