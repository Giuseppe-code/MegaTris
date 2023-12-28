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


public class helpitaActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpita2);
        ImageButton button= findViewById(R.id.next);
        ImageView x = findViewById(R.id.xxx);
        TextView t = findViewById(R.id.main);

        Spannable word = new SpannableString("QUESTA E' LA ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(word);
        Spannable wordTwo = new SpannableString("TABELLA PRINCIPALE");
        wordTwo.setSpan(new ForegroundColorSpan(Color.rgb(0,169,157)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.append(wordTwo);


        ObjectAnimator rotxx = ObjectAnimator.ofFloat(x,"scaleX",1/2f);
        rotxx.setDuration(1000);
        ObjectAnimator rotyy = ObjectAnimator.ofFloat(x,"scaleY",1/2f);
        rotyy.setDuration(1000);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(t, "alpha", 0f, 1f);
        fadeAnim.setDuration(1000);
        fadeAnim.start();
        rotxx.start();
        rotyy.start();


        button.setOnClickListener((View view)->{
            Intent intent = new Intent(helpitaActivity2.this,helpitaActivity3.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);        });


    }
}