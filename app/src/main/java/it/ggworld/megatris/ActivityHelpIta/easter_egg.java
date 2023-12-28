package it.ggworld.megatris.ActivityHelpIta;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import android.os.Bundle;
import android.util.DisplayMetrics;

import android.widget.ImageView;
import android.widget.TextView;

import it.ggworld.megatris.R;


public class easter_egg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);








        setContentView(R.layout.activity_activityperprove);
        ImageView o= findViewById(R.id.O);
        TextView vin = findViewById(R.id.vinci);
        TextView sta = findViewById(R.id.stancanelli);
        int testo = 0;
        int testo2 = 0;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;

            if(width > 1500){
                testo = 40;
                testo2 = 70;

            }else{
                testo = 22;
                testo2 = 28;
            }


        ObjectAnimator anim = ObjectAnimator.ofFloat(o,"scaleX",2f);
        anim.setDuration(1000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(o,"scaleY",2f);
        anim2.setDuration(1000);
        AnimatorSet bouncer = new AnimatorSet();
        bouncer.play(anim).with(anim2);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(vin, "alpha", 0f, 1f);
        fadeAnim.setDuration(2000);
        ValueAnimator fadeAnim2 = ObjectAnimator.ofFloat(sta, "alpha", 0f, 1f);
        fadeAnim2.setDuration(2000);
        AnimatorSet bouncer2 = new AnimatorSet();
        bouncer2.play(fadeAnim).with(fadeAnim2);
        ValueAnimator a = ObjectAnimator.ofFloat(vin, "textSize", testo2,testo);
        a.setDuration(1000);
        ValueAnimator b = ObjectAnimator.ofFloat(sta, "textSize", testo2,testo);
        b.setDuration(1000);
        AnimatorSet bouncer3 = new AnimatorSet();
        bouncer3.play(a).with(b);


        bouncer.start();
        bouncer2.start();
        bouncer3.start();




    }
}