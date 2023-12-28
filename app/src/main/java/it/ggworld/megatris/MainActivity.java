package it.ggworld.megatris;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

import it.ggworld.megatris.ActivityHelpIta.easter_egg;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play=findViewById(R.id.play);
        Button help=findViewById(R.id.help);
        Button options=findViewById(R.id.options);
        ImageButton gg = findViewById(R.id.nomi);




        play.setOnClickListener((View view)->{
            Intent intent = new Intent(MainActivity.this,playerorbotActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        });
        help.setOnClickListener((View view)->{
            Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        options.setOnClickListener((View view)->{
            Intent intent = new Intent(MainActivity.this,optionsActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        gg.setOnClickListener((View view)->{

                Intent intent = new Intent(MainActivity.this, easter_egg.class);
                startActivity(intent);


        });

    }
}