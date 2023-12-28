package it.ggworld.megatris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class playActivity extends AppCompatActivity {
    private final TrisPrimary tris= new TrisPrimary();
    private static int chooseGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_final);
        
        MobileAds.initialize(this, initializationStatus -> {
        });


        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Bundle extras = getIntent().getExtras();
        try{
            chooseGame = extras.getInt("key");
        } catch(NullPointerException e){
            Log.e("errornull","risolto");
        }

        //0=player 1=bot



        //passo l'activity per passare findviewbyid
        tris.Creation(this,chooseGame);

    }

}