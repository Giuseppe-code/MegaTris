package it.ggworld.megatris;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import it.ggworld.megatris.ActivityHelpEn.helpActivity;
import it.ggworld.megatris.ActivityHelpIta.helpitaActivity;


public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingua);

        ImageButton itawhite=findViewById(R.id.itawhite);
        ImageButton itared=findViewById(R.id.itared);
        ImageButton itagreen=findViewById(R.id.itagreen);
        ImageButton usawhite=findViewById(R.id.usawhite);
        ImageButton usared=findViewById(R.id.usared);
        ImageButton usablue=findViewById(R.id.usablue);


        itawhite.setOnClickListener((View view)-> {
                    Intent intent = new Intent(LanguageActivity.this, helpitaActivity.class);
                    startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        itared.setOnClickListener((View view)-> {
            Intent intent = new Intent(LanguageActivity.this, helpitaActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        itagreen.setOnClickListener((View view)-> {
            Intent intent = new Intent(LanguageActivity.this, helpitaActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        usawhite.setOnClickListener((View view)->{
                Intent intent = new Intent(LanguageActivity.this, helpActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });
        usared.setOnClickListener((View view)->{
            Intent intent = new Intent(LanguageActivity.this,helpActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        usablue.setOnClickListener((View view)->{
            Intent intent = new Intent(LanguageActivity.this,helpActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        AnimatorSet set= new AnimatorSet();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width_ = displayMetrics.widthPixels;

        float translation1;
        float translation2;
        float translation3;
        float translation4;


        ViewGroup.LayoutParams params = itared.getLayoutParams();

        //italia

        float target2=  params.width *0.6f;
        float target= width_ * 0.6f -target2;
        translation3= target;
        target= width_ *0.6f -target2;
        translation4= -target  ;

        //usa

        float target3=  params.width *0.6f;
        float target_ = width_ * 0.6f -target3;
        translation2 = target_;
        target_ = width_ *0.6f -target3;
        translation1 = -target_  ;




        ObjectAnimator ita1 = ObjectAnimator.ofFloat(itagreen, "translationX", translation3);
        ita1.setDuration(1000);
        ObjectAnimator ita2 = ObjectAnimator.ofFloat(itared, "translationX", translation4);
        ita2.setDuration(1000);
        ObjectAnimator usa1 = ObjectAnimator.ofFloat(usared, "translationX", translation2);
        usa1.setDuration(1000);
        ObjectAnimator usa2 = ObjectAnimator.ofFloat(usablue, "translationX", translation1);
        usa2.setDuration(1000);

        set.play(ita1).with(ita2);
        set.play(usa1).with(usa2);
        set.start();
    }


    }
