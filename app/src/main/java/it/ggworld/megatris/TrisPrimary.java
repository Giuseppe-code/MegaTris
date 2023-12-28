package it.ggworld.megatris;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import it.ggworld.megatris.EndOfGame.lostActivity;
import it.ggworld.megatris.EndOfGame.drawActivity;
import it.ggworld.megatris.EndOfGame.winO;
import it.ggworld.megatris.EndOfGame.winX;

public class TrisPrimary{
    // O o X , cambiare in protected e togliere i 2 metodi
    private static int chooseGame;
    private static boolean scelta=true;
    protected static int ultimaRisorsa=0;
    protected ImageView turnoo,turnox;
    private TextView time;
    private static int e=0;
    private static final Integer[] valCella = new Integer[9];
    //sequenza degli imagebutton cliccati
    protected static ArrayList<String> sequenza = new ArrayList<>();
    private static int numQuadrante=10;// removeSequenza

    //per passarli al tris primario al tris secondario
    private final ImageButton[][] btn= new ImageButton[9][9];
    protected ImageButton bot, reset;

    //activity per usare findWiewById
    private Activity activity;

    //timer
    protected String tempoG;
    protected static int minutes=0;
    protected static int seconds=0;
    protected static int hours=0;
    protected static Timer timer = new Timer();
    protected static TimerTask timerTask;

    //caselle disponibili
    protected static boolean[] posCasella = new boolean[9];

    //tris secondario
    protected static TrisSecondaryPlayer[] tris= new TrisSecondaryPlayer[9];

    //layout gridimg
    protected static GridLayout[] grid = new GridLayout[9];

    public static boolean firstTime=true;
    //pareggio
    protected static int pareggioGrande=0;

    //ads
    private static InterstitialAd mInterstitialAd;

    TrisPrimary(){
        //rende le caselle editabili
        for (int i = 0; i < 9; i++) {
            posCasella[i]=true;
        }
    }

    //passa l'activity e setta tutto per l'inizio
    public void Creation(Activity activity, int chooseGame){
        this.activity = activity;
        TrisPrimary.chooseGame =chooseGame;
        turnoo = activity.findViewById(R.id.turnoo);
        turnox = activity.findViewById(R.id.turnox);
        seconds=0;
        minutes=0;
        hours=0;
        setAds();
        Initialization();

    }

    public boolean getScelta(){
        return scelta;
    }

    public void setScelta(boolean sceltas){
        scelta=sceltas;

        AnimatorSet clipsr = new AnimatorSet();
        AnimatorSet clips = new AnimatorSet();
        if(scelta){
            turnox.setBackground(null);
            //x diminuisce
            ObjectAnimator dimx = ObjectAnimator.ofFloat(turnox,"scaleX",1f);
            dimx.setDuration(1000);
            ObjectAnimator dimx2 = ObjectAnimator.ofFloat(turnox,"scaleY",1f);
            dimx2.setDuration(1000);
            clips.play(dimx).with(dimx2);

            //cerchio ingrandisce
            turnoo.setBackgroundResource(R.drawable.osenzabordo);
            ObjectAnimator rotxx = ObjectAnimator.ofFloat(turnoo,"scaleX",2f);
            rotxx.setDuration(1000);
            ObjectAnimator rotyy = ObjectAnimator.ofFloat(turnoo,"scaleY",2f);
            rotyy.setDuration(1000);
            clips.play(rotyy).with(rotxx);
         //   clips.play(dimx).before(rotxx);
            clips.start();
        }else {
            turnoo.setBackground(null);
            ObjectAnimator dim = ObjectAnimator.ofFloat(turnoo,"scaleX",1f);
            dim.setDuration(1000);
            ObjectAnimator dim2 = ObjectAnimator.ofFloat(turnoo,"scaleY",1f);
            dim2.setDuration(1000);
            clipsr.play(dim).with(dim2);

            ObjectAnimator rotxx2 = ObjectAnimator.ofFloat(turnox,"scaleX",2f);
            rotxx2.setDuration(1000);
            ObjectAnimator rotyy2 = ObjectAnimator.ofFloat(turnox,"scaleY",2f);
            rotyy2.setDuration(1000);
            clipsr.play(rotyy2).with(rotxx2);
         //   clipsr.play(dim).before(rotxx2);
            turnox.setBackgroundResource(R.drawable.xsenzabordo);
            clipsr.start();
        }
    }

    //cambia la casella in non editabile e decidere se segnare una X, una O o un Pareggio
    public void setPosCasella(int numCasella, GridLayout gridS){
        posCasella[numCasella]=false;
        if(tris[numCasella].getPareggio()!=9){//guarda il pareggio della casella
            if (!scelta) {
                valCella[numCasella] = 0;
                gridS.setBackgroundResource(R.drawable.osenzabordo);
                ValueAnimator fadeAnima = ObjectAnimator.ofFloat(gridS, "alpha", 0f, 1f);
                fadeAnima.setDuration(350);
                fadeAnima.start();
            }
            if (scelta) {
                valCella[numCasella] = 1;
                gridS.setBackgroundResource(R.drawable.xsenzabordo);
                ValueAnimator fadeAnimat = ObjectAnimator.ofFloat(gridS, "alpha", 0f, 1f);
                fadeAnimat.setDuration(350);
                fadeAnimat.start();

            }
        }else {//pareggio
            valCella[numCasella] = 2;
            gridS.setBackgroundResource(R.drawable.pareg);
            ValueAnimator fadeAnima = ObjectAnimator.ofFloat(gridS, "alpha", 0f, 1f);
            fadeAnima.setDuration(350);
            fadeAnima.start();

            Log.i("pareggio", "Grande aumenta"+ pareggioGrande);
        }

        removeSequenza();
        //qui
        controlloPrimary();
    }

    public boolean getPosCasella(int numCasella){//se il quadrante è editabile, si inserisce il num del quadrante
        return posCasella[numCasella];
    }

    public void setSequenza(int numCasella, int index){//quadrante, cella
        sequenza.add(""+ numCasella + index); //da qui
    }

    public int getSequenza(){
        return Character.getNumericValue(sequenza.get(sequenza.size()-1).charAt(1));
    }

    public void removeSequenza(){
        numQuadrante=Character.getNumericValue(sequenza.get(sequenza.size()-1).charAt(0));
        Log.i("remove seq", "entrato");
        //rimuove l'ultima sequenza, attenzione al while del controllo trisecondary
        sequenza.remove(sequenza.size()-1);

        //Cosa succede se è tutto occupato?
        if(sequenza.size()==1 && ultimaRisorsa<8){//fino all'8 quadrante può andare oltre no
            Log.i("remove seq", "entrato if");
            do {
                if(ultimaRisorsa<8){
                    sequenza.add("" + numQuadrante + ultimaRisorsa);

                    ultimaRisorsa++;
                    Log.i("remove seq", "getSequenza---------- "+ ultimaRisorsa);
                    Log.i("remove", "non entrato else"+ ultimaRisorsa + posCasella[getSequenza()]);
                    Log.i("remove", "entrato else"+ ultimaRisorsa + posCasella[getSequenza()]);
                }else{
                    break;
                }
            }while(!posCasella[getSequenza()] || ultimaRisorsa==8);//esce quando è true, ultimaRisorsa non può essere 9
        }

        if(ultimaRisorsa<8){
            if(!posCasella[getSequenza()]){
                removeSequenza();
            }
        }

    }

    //se abbiamo una vittoria, si controllano le file
    public void controlloPrimary(){
        pareggioGrande++;//se arriva a 9 nessuno vince in quanto abbiamo una parità

        Log.i("Controllo", "controllo: entrato ");
        for(int i=0;i<9;i++){
            Log.i("Controllo", "sequenza  "+ i + " " + valCella[i]);
        }
        /*
        0 | 1 | 2
        3 | 4 | 5
        6 | 7 | 8
         */
        for(int i=0;i<3;i++){
            //prima seconda e terza fila orizzontale
            if(valCella[i * 3].equals(valCella[i * 3 + 1]) && valCella[i * 3].equals(valCella[i * 3 + 2]) && valCella[i*3]==1){//orizzontale x;
                endGame(1);
                break;
            }else if(valCella[i * 3].equals(valCella[i * 3 + 1]) && valCella[i * 3].equals(valCella[i * 3 + 2]) && valCella[i*3]==0) {//orizzontale O
                endGame(0);
                break;
            }else if(valCella[i].equals(valCella[i + 3]) && valCella[i].equals(valCella[i + 6]) && valCella[i]==1) {//verticalex
                endGame(1);
                break;
            }else if(valCella[i].equals(valCella[i + 3]) && valCella[i].equals(valCella[i + 6]) && valCella[i]==0){//verticale O
                endGame(0);
                break;
            }else if(valCella[0].equals(valCella[4]) && valCella[0].equals(valCella[8]) && valCella[0]==1){//obliquo sin destra x
                endGame(1);
                break;
            }else if(valCella[0].equals(valCella[4]) && valCella[0].equals(valCella[8]) && valCella[0]==0){//obliquo sin destra 0
                endGame(0);
                break;
            }else if(valCella[6].equals(valCella[4]) && valCella[6].equals(valCella[2]) && valCella[6]==1){//obliquo destra sin x
                endGame(1);
                break;
            }else if(valCella[6].equals(valCella[4]) && valCella[6].equals(valCella[2]) && valCella[6]==0){//obliquo destra sin 0
                endGame(0);
                break;
            }

        }
        if(pareggioGrande==9){
            Log.i("pareggio", "Grande entrato"+ pareggioGrande);
            endGame(2);
        }
    }

    //verifica a chi attribuire la vincita
    public void endGame(int j) {

        if (mInterstitialAd != null) {
            Log.i("error:ads", "entrato diverso da null");
            mInterstitialAd.show(activity);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    if (j == 0) {//vince O
                        Intent intent = new Intent(activity, winO.class);
                        tempoG = "" + time.getText();
                        intent.putExtra("key", tempoG);
                        reset();
                        activity.startActivity(intent);

                    }
                    if (j == 1) {//vince x
                        tempoG = (String) time.getText();

                        Intent intent;
                        if (tris[0] instanceof TrisSecondaryBot) {
                            intent = new Intent(activity, lostActivity.class);
                        } else {
                            intent = new Intent(activity, winX.class);
                            intent.putExtra("key", tempoG);
                        }
                        reset();
                        activity.startActivity(intent);

                    }
                    //pareggio
                    if (j == 2) {//vince pareggio
                        Log.i("pareggio", "EndGame dentro: " + pareggioGrande);
                        Intent intent = new Intent(activity, drawActivity.class);
                        tempoG = (String) time.getText();
                        intent.putExtra("key", tempoG);
                        reset();
                        activity.startActivity(intent);

                    }
                    mInterstitialAd = null;
                    setAds();
                }
            });
        }else {
            Log.i("error:ads", "entrato con null");
            if (j == 0) {//vince O
                Intent intent = new Intent(activity, winO.class);
                tempoG = "" + time.getText();
                intent.putExtra("key", tempoG);
                reset();
                activity.startActivity(intent);

            }
            if (j == 1) {//vince x
                tempoG = (String) time.getText();

                Intent intent;
                if (tris[0] instanceof TrisSecondaryBot) {
                    intent = new Intent(activity, lostActivity.class);
                } else {
                    intent = new Intent(activity, winX.class);
                    intent.putExtra("key", tempoG);
                }
                reset();
                activity.startActivity(intent);

            }

            //pareggio
            if (j == 2) {//vince pareggio
                Log.i("pareggio", "EndGame dentro: " + pareggioGrande);
                Intent intent = new Intent(activity, drawActivity.class);
                tempoG = (String) time.getText();
                intent.putExtra("key", tempoG);
                reset();
                activity.startActivity(intent);

            }
        }
    }

    public void reset(){
        if(timerTask != null){
            timerTask.cancel();
        }
        for(int i=0;i<9;i++){
           posCasella[i] = true;
       }
        ultimaRisorsa= 0;
        sequenza.clear();
        scelta= true;
        seconds=0;
        minutes=0;
        hours=0;
        pareggioGrande=0;
    }

    public void Initialization(){
        //bottone quando cliccato farà vedere la sequenza
        reset();
        for (int i = 0; i < 9; i++) {
            valCella[i]=3;
        }
        if(chooseGame==0){
            for (int i = 0; i < 9; i++) {
                tris[i]=new TrisSecondaryPlayer(this);

            }
        }else{//BOT
            for (int i = 0; i < 9; i++) {
                tris[i]=new TrisSecondaryBot(this);
            }
        }

        btn[0][0] = activity.findViewById(R.id.button01);
        btn[0][1] = activity.findViewById(R.id.button02);
        btn[0][2] = activity.findViewById(R.id.button03);
        btn[0][3] = activity.findViewById(R.id.button04);
        btn[0][4] = activity.findViewById(R.id.button05);
        btn[0][5] = activity.findViewById(R.id.button06);
        btn[0][6] = activity.findViewById(R.id.button07);
        btn[0][7] = activity.findViewById(R.id.button08);
        btn[0][8] = activity.findViewById(R.id.button09);

        tris[0].InitializeListener(btn[0], 0);
        btn[1][0] = activity.findViewById(R.id.button11);
        btn[1][1] = activity.findViewById(R.id.button12);
        btn[1][2] = activity.findViewById(R.id.button13);
        btn[1][3] = activity.findViewById(R.id.button14);
        btn[1][4] = activity.findViewById(R.id.button15);
        btn[1][5] = activity.findViewById(R.id.button16);
        btn[1][6] = activity.findViewById(R.id.button17);
        btn[1][7] = activity.findViewById(R.id.button18);
        btn[1][8] = activity.findViewById(R.id.button19);

        tris[1].InitializeListener(btn[1], 1);

        btn[2][0] = activity.findViewById(R.id.button21);
        btn[2][1] = activity.findViewById(R.id.button22);
        btn[2][2] = activity.findViewById(R.id.button23);
        btn[2][3] = activity.findViewById(R.id.button24);
        btn[2][4] = activity.findViewById(R.id.button25);
        btn[2][5] = activity.findViewById(R.id.button26);
        btn[2][6] = activity.findViewById(R.id.button27);
        btn[2][7] = activity.findViewById(R.id.button28);
        btn[2][8] = activity.findViewById(R.id.button29);

        tris[2].InitializeListener(btn[2], 2);

        btn[3][0] = activity.findViewById(R.id.button31);
        btn[3][1] = activity.findViewById(R.id.button32);
        btn[3][2] = activity.findViewById(R.id.button33);
        btn[3][3] = activity.findViewById(R.id.button34);
        btn[3][4] = activity.findViewById(R.id.button35);
        btn[3][5] = activity.findViewById(R.id.button36);
        btn[3][6] = activity.findViewById(R.id.button37);
        btn[3][7] = activity.findViewById(R.id.button38);
        btn[3][8] = activity.findViewById(R.id.button39);

        tris[3].InitializeListener(btn[3], 3);

        btn[4][0] = activity.findViewById(R.id.button41);
        btn[4][1] = activity.findViewById(R.id.button42);
        btn[4][2] = activity.findViewById(R.id.button43);
        btn[4][3] = activity.findViewById(R.id.button44);
        btn[4][4] = activity.findViewById(R.id.button45);
        btn[4][5] = activity.findViewById(R.id.button46);
        btn[4][6] = activity.findViewById(R.id.button47);
        btn[4][7] = activity.findViewById(R.id.button48);
        btn[4][8] = activity.findViewById(R.id.button49);
        tris[4].InitializeListener(btn[4], 4);

        btn[5][0] = activity.findViewById(R.id.button51);
        btn[5][1] = activity.findViewById(R.id.button52);
        btn[5][2] = activity.findViewById(R.id.button53);
        btn[5][3] = activity.findViewById(R.id.button54);
        btn[5][4] = activity.findViewById(R.id.button55);
        btn[5][5] = activity.findViewById(R.id.button56);
        btn[5][6] = activity.findViewById(R.id.button57);
        btn[5][7] = activity.findViewById(R.id.button58);
        btn[5][8] = activity.findViewById(R.id.button59);
        tris[5].InitializeListener(btn[5], 5);

        btn[6][0] = activity.findViewById(R.id.button61);
        btn[6][1] = activity.findViewById(R.id.button62);
        btn[6][2] = activity.findViewById(R.id.button63);
        btn[6][3] = activity.findViewById(R.id.button64);
        btn[6][4] = activity.findViewById(R.id.button65);
        btn[6][5] = activity.findViewById(R.id.button66);
        btn[6][6] = activity.findViewById(R.id.button67);
        btn[6][7] = activity.findViewById(R.id.button68);
        btn[6][8] = activity.findViewById(R.id.button69);

        tris[6].InitializeListener(btn[6], 6);

        btn[7][0] = activity.findViewById(R.id.button71);
        btn[7][1] = activity.findViewById(R.id.button72);
        btn[7][2] = activity.findViewById(R.id.button73);
        btn[7][3] = activity.findViewById(R.id.button74);
        btn[7][4] = activity.findViewById(R.id.button75);
        btn[7][5] = activity.findViewById(R.id.button76);
        btn[7][6] = activity.findViewById(R.id.button77);
        btn[7][7] = activity.findViewById(R.id.button78);
        btn[7][8] = activity.findViewById(R.id.button79);


        tris[7].InitializeListener(btn[7], 7);

        btn[8][0] = activity.findViewById(R.id.button81);
        btn[8][1] = activity.findViewById(R.id.button82);
        btn[8][2] = activity.findViewById(R.id.button83);
        btn[8][3] = activity.findViewById(R.id.button84);
        btn[8][4] = activity.findViewById(R.id.button85);
        btn[8][5] = activity.findViewById(R.id.button86);
        btn[8][6] = activity.findViewById(R.id.button87);
        btn[8][7] = activity.findViewById(R.id.button88);
        btn[8][8] = activity.findViewById(R.id.button89);

        tris[8].InitializeListener(btn[8], 8);

        //grid

        grid[0] = activity.findViewById(R.id.grid0);
        grid[1] = activity.findViewById(R.id.grid1);
        grid[2] = activity.findViewById(R.id.grid2);
        grid[3] = activity.findViewById(R.id.grid3);
        grid[4] = activity.findViewById(R.id.grid4);
        grid[5] = activity.findViewById(R.id.grid5);
        grid[6] = activity.findViewById(R.id.grid6);
        grid[7] = activity.findViewById(R.id.grid7);
        grid[8] = activity.findViewById(R.id.grid8);

        for (int i = 0; i < 9; i++) {
            tris[i].setGridd(grid[i]);
        }
        time = activity.findViewById(R.id.tempoTrastxt);

        bot = activity.findViewById(R.id.where);

        reset = activity.findViewById(R.id.retry1);

        bot.setOnClickListener((View view)-> {
            if(!firstTime){
                ValueAnimator fadeAnim = ObjectAnimator.ofFloat(TrisPrimary.grid[getSequenza()], "alpha", 0f, 1f);
                fadeAnim.setDuration(800);
                fadeAnim.start();
            }
        });

        reset.setOnClickListener((View view)-> {
            e++;

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if(e>=1){
                ObjectAnimator rot = ObjectAnimator.ofFloat(reset,"rotation",-375);
                rot.setDuration(900);
                rot.start();
            }
            builder.setTitle("RESET");
            builder.setMessage("Are you sure?");

            builder.setPositiveButton("YES", (dialog, which) -> {

                Intent intent = new Intent(activity,playerorbotActivity.class);
                activity.startActivity(intent);
                activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                dialog.dismiss();
                ObjectAnimator rot2 = ObjectAnimator.ofFloat(reset,"rotation",15);
                rot2.setDuration(700);
                rot2.start();
            });
            builder.setNegativeButton("NO", (dialog, which) -> {
                ObjectAnimator rot2 = ObjectAnimator.ofFloat(reset,"rotation",-0);
                rot2.setDuration(500);
                rot2.start();
                dialog.dismiss();
            });
            AlertDialog alert = builder.create();
            alert.show();
        });


        tempo();

    }

    public void tempo(){//orologio
        Log.i("tempo", "t3");



        Log.i("tempo", "t4");

        timerTask = new TimerTask() {
            @Override
            public void run() {
                seconds++;

                if(seconds>59){
                    minutes++;
                    seconds=0;
                }
                if(minutes>59){
                    hours++;
                    minutes=0;
                    seconds=0;
                }
                if(hours<1){
                    String timeInHHMMSS = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                    time.setText(timeInHHMMSS);
                }else if(hours<24){
                    String timeInHHMMSS = String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds);
                    time.setText(timeInHHMMSS);
                }else{
                    time.setText(R.string.bro);
                }

            }
        };
        timer.scheduleAtFixedRate(timerTask,0, 1000);

    }

    public void bot(){
        tris[getSequenza()].gameBot();
    }

    public void setAds(){
    //unit test ca-app-pub-3940256099942544/8691691433
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(activity,"ca-app-pub-3940256099942544/8691691433", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                        Log.i("error:ads", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("error:ads", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }

}
