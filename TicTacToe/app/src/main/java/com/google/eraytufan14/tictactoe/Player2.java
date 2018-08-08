package com.google.eraytufan14.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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


public class Player2 extends Activity {
    int geributton = 0;
    InterstitialAd mInterstitialAd;
    int adoyunsayisi;
    int x;
    int movesayisi;
    Game oyun = new Game();
    ImageButton scaryButton;
    MediaPlayer scarySound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player2);

        scaryButton = (ImageButton) findViewById(R.id.imagescary);
        //scarySound = MediaPlayer.create(this, R.raw.scarysound);

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

        adoyunsayisi = 0;
        movesayisi = 0;

        //korkunclu yer


        scaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd = new InterstitialAd(Player2.this);
                    mInterstitialAd.setAdUnitId("ca-app-pub-9306668647827970/1531358042");

                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            requestNewInterstitial();
                        }
                    });

                    requestNewInterstitial();
                }
                scaryButton.setVisibility(View.INVISIBLE);
            }
        });

        x = 0;
        final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        final ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        final ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.imageButton9);

        //button1.setImageResource(android.R.color.transparent);
        //button3.setImageResource(R.drawable.playerx);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(1)) {
                        oyun.makeMove(1);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            //button1.setBackgroundColor(R.color.background_material_dark);
                            button1.setImageResource(R.drawable.playerx);
                        } else {
                            button1.setImageResource(R.drawable.playero);
                            if(movesayisi>=5){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(1) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("You Win");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(1) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(1) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }

                    oyun.changeUser();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(2)) {
                        oyun.makeMove(2);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button2.setImageResource(R.drawable.playerx);
                        } else {
                            button2.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if (oyun.didItFinish(2) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();

                    } else if (oyun.didItFinish(2) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(2) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }

                    oyun.changeUser();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(3)) {
                        oyun.makeMove(3);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button3.setImageResource(R.drawable.playerx);
                        } else {
                            button3.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(3) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(3) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(3) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }

                    oyun.changeUser();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(4)) {
                        oyun.makeMove(4);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button4.setImageResource(R.drawable.playerx);
                        } else {
                            button4.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(4) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(4) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(4) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(5)) {
                        oyun.makeMove(5);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button5.setImageResource(R.drawable.playerx);
                        } else {
                            button5.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(5) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(5) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(5) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(6)) {
                        oyun.makeMove(6);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button6.setImageResource(R.drawable.playerx);
                        } else {
                            button6.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(6) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(6) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(6) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(7)) {
                        oyun.makeMove(7);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button7.setImageResource(R.drawable.playerx);
                        } else {
                            button7.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(7) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(7) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(7) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(8)) {
                        oyun.makeMove(8);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button8.setImageResource(R.drawable.playerx);
                        } else {
                            button8.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(8) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(8) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(8) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();

                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x != 0) {
                    return;
                }

                if (oyun.doesItContinue()) {
                    if (oyun.canYouPlay(9)) {
                        oyun.makeMove(9);
                        movesayisi++;
                        if (oyun.getPlayer() == 1) {
                            button9.setImageResource(R.drawable.playerx);
                        } else {
                            button9.setImageResource(R.drawable.playero);
                            if(movesayisi>=4){
                                scarySound.start();
                                scaryButton.setVisibility(View.VISIBLE);
                                scaryButton.bringToFront();
                                restartGame();

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "You cant play this move", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oyun.didItFinish(9) == 1) {
                        //Toast.makeText(getApplicationContext(), "X won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("X won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(9) == 2) {
                        //Toast.makeText(getApplicationContext(), "O won the game", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("O won the game");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    } else if (oyun.didItFinish(9) == 4) {
                        //Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                        x = 1;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Player2.this);
                        builder1.setTitle("Draw");
                        builder1.setMessage("Play Again");
                        builder1.setCancelable(true);
                        builder1.setNeutralButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        restartGame();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                    oyun.changeUser();
                }
            }
        });

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
                    adoyunsayisi =0;
                }
            }catch (Exception e){}
        }
        adoyunsayisi++;
        oyun.restart();
        x=0;
        movesayisi=-5000;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player2, menu);
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
    protected void onDestroy() {

        super.onDestroy();

        scarySound.stop();
        scarySound.reset();
        scarySound.release();
        scarySound = null;
    }
    @Override
    public void onBackPressed() {
        //Log.d("CDA", "onBackPressed Called");



        if (mInterstitialAd.isLoaded() && geributton == 0) {
            mInterstitialAd.show();
            mInterstitialAd = new InterstitialAd(Player2.this);
            mInterstitialAd.setAdUnitId("ca-app-pub-9306668647827970/1531358042");

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Player2.super.onBackPressed();
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

