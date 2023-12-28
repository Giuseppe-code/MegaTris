package it.ggworld.megatris;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import android.view.View;
import android.widget.ImageButton;



import java.util.Random;

public class TrisSecondaryBot  extends TrisSecondaryPlayer implements View.OnClickListener {
    //false X true O X=bot
    Random rand = new Random();
    public TrisSecondaryBot(TrisPrimary t) {
        trisP=t;
    }

    @Override
    public void onClick(View v) {
        valueQuadrante = trisP.getPosCasella(numQuadrante);

        if (valueQuadrante) {
            sceltaVal = trisP.getScelta();
            for (int i = 0; i < 9; i++) {
                if (v == casella[i]) {
                    index = i;//inidice della casella da cambiare
                }
            }

            //se non è la prima volta
            if (!TrisPrimary.firstTime) {
                seq = trisP.getSequenza();
            } else {//eseguito solo la prima volta
                trisP.setSequenza(numQuadrante, index);
                seq = numQuadrante;
            }
            if (numQuadrante == seq) {//seq

                if (valCellaSecondary[index] != 0 && valCellaSecondary[index] != 1) {//se è gia stato cambiato non si puòcambiare
                        ((ImageButton) v).setImageResource(R.drawable.osenzabordo);
                        ValueAnimator fadeAnima = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                        fadeAnima.setDuration(300);
                        fadeAnima.start();
                        valCellaSecondary[index] = 0;
                    if (TrisPrimary.firstTime) {
                        TrisPrimary.firstTime = false;
                    } else {
                        if (!TrisPrimary.posCasella[index]) {
                            trisP.setSequenza(numQuadrante, numQuadrante);
                        } else
                            trisP.setSequenza(numQuadrante, index);
                    }
                    sceltaVal = !sceltaVal;
                    trisP.setScelta(sceltaVal);
                    controlloSecondary();
                    trisP.bot();
                    //X o O
                }

            } else {
                ValueAnimator fadeAnim = ObjectAnimator.ofFloat(TrisPrimary.tris[seq].gridd, "alpha", 0f, 1f);
                fadeAnim.setDuration(800);
                fadeAnim.start();
            }
        }

        if(index==300){
            gameBot();
        }
    }
    public void gameBot() {
        int mossa;//se è 9 allora non applicarla
        //Random
        mossa=mancante();
        if(mossa!=9){
            esegui(mossa);
            return;
        }

        do{
            mossa=rand.nextInt(9);
        }while(possibile(mossa)==0);
        esegui(mossa);


    }

    private int mancante() {
        for (int i = 0; i < 3; i++) {
            //prima seconda e terza fila orizzontale
            //manca il terzo
            if (valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 1]) && valCellaSecondary[i * 3 + 2] == 3 && valCellaSecondary[i * 3] == 1) {//orizzontale x
                if(possibile(i*3+2)==1) return i*3+2;
            }
            //manca il secondo
            if (valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 2]) && valCellaSecondary[i * 3 + 1] == 3 && valCellaSecondary[i * 3] == 1) {//orizzontale x
                if(possibile(i*3+1)==1) return i*3+1;
            }
            //manca il primo
            if (valCellaSecondary[i * 3 + 2].equals(valCellaSecondary[i * 3 + 1]) && valCellaSecondary[i * 3] == 3 && valCellaSecondary[i * 3+1] == 1) {//orizzontale x
                if(possibile(i*3)==1) return i*3;
            }
            //manca il terzo
            if (valCellaSecondary[i].equals(valCellaSecondary[i + 3]) && valCellaSecondary[i + 6] == 3 && valCellaSecondary[i] == 1) {//verticalex
                if(possibile(i+6)==1) return i+6;
            }
            //manca il secondo
            if (valCellaSecondary[i].equals(valCellaSecondary[i + 6]) && valCellaSecondary[i + 3] == 3 && valCellaSecondary[i] == 1) {//verticalex
                if(possibile(i+3)==1) return i+3;
            }
            //manca il primo
            if (valCellaSecondary[i + 3].equals(valCellaSecondary[i + 6]) && valCellaSecondary[i] == 3 && valCellaSecondary[i+3] == 1) {//verticalex
                if(possibile(i)==1) return i;
            }
        }
        //manca primo
        if(valCellaSecondary[0].equals(valCellaSecondary[4]) && valCellaSecondary[8]==3 && valCellaSecondary[0]== 1){//obliquo sin destra x
            if(possibile(8)==1) return 8;
        }
        //manca secondo
        if(valCellaSecondary[0].equals(valCellaSecondary[8]) && valCellaSecondary[4]==3 && valCellaSecondary[0]== 1){//obliquo sin destra x
            if(possibile(4)==1) return 4;
        }
        //manca terzo
        if(valCellaSecondary[8].equals(valCellaSecondary[4]) && valCellaSecondary[0]==3 && valCellaSecondary[8]== 1){//obliquo sin destra x
            if(possibile(0)==1) return 0;
        }

        //manca primo
        if(valCellaSecondary[6].equals(valCellaSecondary[4]) && valCellaSecondary[2]==3 && valCellaSecondary[6]== 1){//obliquo destra sin x
            if(possibile(2)==1) return 2;
        }
        if(valCellaSecondary[6].equals(valCellaSecondary[2]) && valCellaSecondary[4]==3 && valCellaSecondary[6]== 1){//obliquo destra sin x
            if(possibile(4)==1) return 4;
        }
        if(valCellaSecondary[2].equals(valCellaSecondary[4]) && valCellaSecondary[6]==3 && valCellaSecondary[2]== 1){//obliquo destra sin x
            if(possibile(2)==1) return 2;
        }

        return 9;
    }

    public int possibile(int index) {// se è possibile compiere l'azione
        if (valCellaSecondary[index] != 0 && valCellaSecondary[index] != 1) {//se è gia stato cambiato non si puòcambiare
            return 1;
        }else
            return 0;

    }

    public void esegui(int index) {
        casella[index].setImageResource(R.drawable.xsenzabordo);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(casella[index], "alpha", 0f, 1f);
        fadeAnim.setDuration(1800);
        fadeAnim.start();


        valCellaSecondary[index] = 1;
        if (!TrisPrimary.posCasella[index]) {
            trisP.setSequenza(numQuadrante, numQuadrante);
        } else
            trisP.setSequenza(numQuadrante, index);
        sceltaVal=trisP.getScelta();
        sceltaVal = !sceltaVal;
        trisP.setScelta(sceltaVal);
        controlloSecondary();
    }







}
