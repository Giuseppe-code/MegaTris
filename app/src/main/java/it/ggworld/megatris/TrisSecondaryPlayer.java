package it.ggworld.megatris;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;




public class TrisSecondaryPlayer implements View.OnClickListener {
    protected TrisPrimary trisP;
    //9 caselle del tris
    protected ImageButton[] casella= new ImageButton[9];

    //false X true O
    protected boolean sceltaVal=true;

    //interi per controlllo vittoria
    protected Integer[] valCellaSecondary = new Integer[9];

    protected int numQuadrante;//primo, secondo, terzo ...quadrante

    //viene inserito il numero booleano del numCasella
    protected boolean valueQuadrante =true;//true modificabile, false non modificabile

    //prima volta per la sequenza


    protected int seq=0;
    protected GridLayout gridd;
    //index
    protected int index=0;

    protected static int pareggioS=0;

    public TrisSecondaryPlayer(TrisPrimary t) {
        trisP=t;
    }

    public TrisSecondaryPlayer() {}

    //inizializzazione, caricamento delle risorse
    public void InitializeListener(ImageButton[] btn, int num) {
        TrisPrimary.firstTime=true;
        numQuadrante =num;
        casella=btn;


        for (int i = 0; i < 9; i++) {
            casella[i].setOnClickListener(this);
            valCellaSecondary[i]=3;
        }

        seq= numQuadrante;
        valueQuadrante =trisP.getPosCasella(numQuadrante);
    }


    @Override
    public void onClick(View v) {

        valueQuadrante = trisP.getPosCasella(numQuadrante);

        if (valueQuadrante) {//se è vero
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
            if (numQuadrante == seq) {//seq se la casella scelta corrisponde alla casella da usare
                if (valCellaSecondary[index] != 0 && valCellaSecondary[index] != 1) {//se è gia stato cambiato non si puòcambiare
                    if (!sceltaVal) {
                        ((ImageButton) v).setImageResource(R.drawable.xsenzabordo);
                        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                        fadeAnim.setDuration(300);
                        fadeAnim.start();
                        valCellaSecondary[index] = 1;
                    } else {
                        ((ImageButton) v).setImageResource(R.drawable.osenzabordo);
                        ValueAnimator fadeAnima = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                        fadeAnima.setDuration(300);
                        fadeAnima.start();
                        valCellaSecondary[index] = 0;
                    }
                    if(TrisPrimary.firstTime)
                    {
                        TrisPrimary.firstTime=false;
                    }else{
                        if(!TrisPrimary.posCasella[index]){
                            trisP.setSequenza(numQuadrante, numQuadrante);
                        }else
                            trisP.setSequenza(numQuadrante,index);
                    }
                    sceltaVal = !sceltaVal;
                    trisP.setScelta(sceltaVal);
                    controlloSecondary();
                }
            }else{
                ValueAnimator fadeAnim = ObjectAnimator.ofFloat(TrisPrimary.tris[seq].gridd, "alpha", 0f, 1f);
                fadeAnim.setDuration(800);
                fadeAnim.start();
            }
         }
    }

    public void controlloSecondary(){

        for(int i=0;i<9;i++){
            Log.i("Controllo", "sequenza  "+ i + " " + valCellaSecondary[i]);
        }
        /*
        0 | 1 | 2
        3 | 4 | 5
        6 | 7 | 8
         */
        for(int i=0;i<3;i++){
            //prima seconda e terza fila orizzontale
            if(valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 1]) && valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 2]) && valCellaSecondary[i*3]==1){//orizzontale x
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa<8){
                    Log.i("remove seq", "entrato if controllo 1");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 1]) && valCellaSecondary[i * 3].equals(valCellaSecondary[i * 3 + 2]) && valCellaSecondary[i*3]==0) {//orizzontale O
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 2");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[i].equals(valCellaSecondary[i + 3]) && valCellaSecondary[i].equals(valCellaSecondary[i + 6]) && valCellaSecondary[i]==1) {//verticalex
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 3");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[i].equals(valCellaSecondary[i + 3]) && valCellaSecondary[i].equals(valCellaSecondary[i + 6]) && valCellaSecondary[i]==0){//verticale O
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 4");
                    trisP.removeSequenza();
                }
                break;

            }else if(valCellaSecondary[0].equals(valCellaSecondary[4]) && valCellaSecondary[0].equals(valCellaSecondary[8]) && valCellaSecondary[0]==1){//obliquo sin destra x
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 5");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[0].equals(valCellaSecondary[4]) && valCellaSecondary[0].equals(valCellaSecondary[8]) && valCellaSecondary[0]==0){//obliquo sin destra 0
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()]){
                    Log.i("remove seq", "entrato if controllo 6");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[6].equals(valCellaSecondary[4]) && valCellaSecondary[6].equals(valCellaSecondary[2]) && valCellaSecondary[6]==1){//obliquo destra sin x
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 7");
                    trisP.removeSequenza();
                }
                break;
            }else if(valCellaSecondary[6].equals(valCellaSecondary[4]) && valCellaSecondary[6].equals(valCellaSecondary[2]) && valCellaSecondary[6]==0){//obliquo destra sin 0
                removeCasella();
                trisP.setPosCasella(numQuadrante, gridd);
                trisP.setSequenza(numQuadrante,index);
                while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                    Log.i("remove seq", "entrato if controllo 8");
                    trisP.removeSequenza();

                }
                break;
            }else{
                pareggioS=0;
                for(int j=0;j<9;j++){
                    if(valCellaSecondary[j] ==0 || valCellaSecondary[j]==1){//sono presenti x e 0
                        pareggioS++;
                        Log.i("pareggioAumento","pareggio"+pareggioS + "quad " + numQuadrante );
                    }
                }
                if(pareggioS==9){//è possibile fare il pareggio
                    Log.i("pareggioAumento2","pareggio dentro"+pareggioS);
                    removeCasella();
                    trisP.setPosCasella(numQuadrante, gridd);
                    trisP.setSequenza(numQuadrante,index);
                    while(!TrisPrimary.posCasella[trisP.getSequenza()] && TrisPrimary.ultimaRisorsa <8){
                        trisP.removeSequenza();
                    }
                    break;
                }else
                    pareggioS=0;

            }
        }
    }

    public int getPareggio(){
        return pareggioS;
    }

    public void removeCasella(){
        for (int i = 0; i < 9; i++) {
            casella[i].setImageResource(0);
        }
    }


    public void setGridd(GridLayout gridd){
        this.gridd = gridd;
    }

    public void gameBot(){
    }

}
