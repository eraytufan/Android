package com.google.eraytufan14.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;


public class Easy extends Activity {
    int geributton = 0;
    InterstitialAd mInterstitialAd;
    Game oyun = new Game();
    int x;
    int adoyunsayisi = 0;
    int toplamoyunsayisi =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player2);

        try {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-9306668647827970/1531358042");

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();
                }
            });

            requestNewInterstitial();
        }catch (Exception e){

        }

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        final ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        final ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.imageButton9);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button1, 1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button2, 2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button3, 3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button4, 4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button5, 5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button6, 6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button7, 7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button8, 8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonpress(button9, 9);
            }
        });
    }

    private void computerMove(){


        int randomnumber = oyun.wheretoPutEasy();



        oyun.makeMove(randomnumber);
        ImageButton randomButton = this.returnButton(randomnumber);

        randomButton.setImageResource(R.drawable.playero);

        if(oyun.didItFinish(randomnumber) == 2) {
            //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
            x = 1;
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("You Lose");
            builder1.setMessage("Play Again");
            builder1.setCancelable(true);
            builder1.setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            restartGame();
                            toplamoyunsayisi++;
                            adoyunsayisi++;
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

        else if(oyun.didItFinish(randomnumber) == 4){
            //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
            x=1;
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("Draw");
            builder1.setMessage("Play Again");
            builder1.setCancelable(true);
            builder1.setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            restartGame();
                            toplamoyunsayisi++;
                            adoyunsayisi++;
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

        oyun.changeUser();

    }

    private ImageButton returnButton(int number){
        final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        final ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        final ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.imageButton9);
        switch(number){
            case 1:
                return button1;
            case 2:
                return button2;
            case 3:
                return button3;
            case 4:
                return button4;
            case 5:
                return button5;
            case 6:
                return button6;
            case 7:
                return button7;
            case 8:
                return button8;
            case 9:
                return button9;
        }
        return button1;
    }

    private void buttonpress(ImageButton buttonX, int buttonNumber){
        if(x !=0){
            return;
        }

        if(oyun.doesItContinue()) {
            if (oyun.canYouPlay(buttonNumber)) {
                oyun.makeMove(buttonNumber);

                buttonX.setImageResource(R.drawable.playerx);



            } else {
                Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                return;
            }

            if (oyun.didItFinish(buttonNumber) == 1){
                //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("You Win");
                builder1.setMessage("Play Again");
                builder1.setCancelable(true);
                builder1.setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                restartGame();
                                toplamoyunsayisi++;
                                adoyunsayisi++;
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                x = 1;
            }
            /*else if(oyun.didItFinish(1) == 2){
                Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                x=1;
            }*/

            else if(oyun.didItFinish(buttonNumber) == 4){
                //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Draw");
                builder1.setMessage("Play Again");
                builder1.setCancelable(true);
                builder1.setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                restartGame();
                                toplamoyunsayisi++;
                                adoyunsayisi++;
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                x=1;
            }

            oyun.changeUser();

            if(x == 0){
                this.computerMove();
            }
        }
    }

    private void restartGame(){
        final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        final ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        final ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.imageButton9);

        button1.setImageResource(0);
        button2.setImageResource(0);
        button3.setImageResource(0);
        button4.setImageResource(0);
        button5.setImageResource(0);
        button6.setImageResource(0);
        button7.setImageResource(0);
        button8.setImageResource(0);
        button9.setImageResource(0);

        if(adoyunsayisi>=7){
            try{
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd = new InterstitialAd(this);
                    mInterstitialAd.setAdUnitId("ca-app-pub-9306668647827970/1531358042");

                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            requestNewInterstitial();
                        }
                    });

                    requestNewInterstitial();
                    adoyunsayisi = 0;
                }
            }catch (Exception e){}
        }

        x=0;
        oyun.restart();
        if(toplamoyunsayisi%2 ==0){
            computerMove();
        }


        /*Intent asd = new Intent(getApplicationContext(), HardMode.class);
        asd.putExtra("asd",);
        startActivity(asd);*/


    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_easy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //Log.d("CDA", "onBackPressed Called");



        if (mInterstitialAd.isLoaded() && geributton == 0) {
            mInterstitialAd.show();
            mInterstitialAd = new InterstitialAd(Easy.this);
            mInterstitialAd.setAdUnitId("ca-app-pub-9306668647827970/1531358042");

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Easy.super.onBackPressed();
                }
            });

            requestNewInterstitial();
            geributton++;
        }

        else{
            super.onBackPressed();
        }
    }
}
