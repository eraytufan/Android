package com.example.dogukanceliker.balanceonterope3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    double ax,xvalue;
    TextView x_text, y_text, z_text, turncommand;
    ImageView image, imageDirection;
    int y, random;
    boolean directionRight;
    boolean isGame;
    int score = 25;
    int time = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image = (ImageView) findViewById(R.id.imageView);
        imageDirection = (ImageView) findViewById(R.id.imageView3);
        Random r = new Random();
        random = r.nextInt(2);//randomly fall either left or right
        directionRight = false;
        if (random == 0){
            random = -1;
            directionRight = true;
        }
        x_text=(TextView)findViewById(R.id.textView);
        y_text=(TextView)findViewById(R.id.textView2);
        z_text=(TextView)findViewById(R.id.textView3);
        turncommand=(TextView)findViewById(R.id.textView4);//Gives the user how to turn the device
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        y = 5;
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(time);//time starts with 1000 but with time decreases. This makes the game more difficult with time.
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(random == 0)
                                {
                                    Random r = new Random();
                                    random = r.nextInt(2);
                                    directionRight = false;
                                    if (random == 0){
                                        random = -3;
                                        directionRight = true;
                                    }
                                }
                                if(random <50 && random >-50) {
                                    if (random > 0) {//If man is falling left
                                        if (directionRight) {
                                            random = -3;//The man starts to fall right

                                        } else {
                                            random = random + 3;//the man falls to left faster
                                        }
                                    } else {//If the man is falling right
                                        if (directionRight) {
                                            random = random - 3;//The man starts to fall right faster
                                        } else {
                                            random = 3;//The man starts to fall left
                                        }

                                    }

                                }

                                //y= y+1;
                                x_text.setText("Fall value:" + random);
                                if(score != 0) {
                                    score = score + 25;
                                }
                                if(time > 300) {
                                    time = time - 10;
                                }
                                x_text.setText("Score:" + score);


                                y_text.setText("Random:" + random);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();




    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            xvalue=event.values[0];//Get X vakue of magnotemeter



            ax = xvalue + random;//add magnotemeter value with the falling value. So the user can keep the man in balance.
            //x_text.setText("x:" + ax);
            //If the value is too high, the man dies.
            if(ax > 50){
                image.setImageResource(R.drawable.man6);
                turncommand.setText("Game Over");
                imageDirection.setImageResource(R.drawable.stop);
                isGame = false;
                score = 0;
            }
            //The man is about to die by falling left
            else if(ax > 40){
                image.setImageResource(R.drawable.man1);
                turncommand.setText("Turn Right");
                imageDirection.setImageResource(R.drawable.right);
                directionRight = false;
            }
            //the man is slightly falling to left
            else if(ax > 23){
                image.setImageResource(R.drawable.man2);
                turncommand.setText("Turn Right");
                imageDirection.setImageResource(R.drawable.right);
                directionRight = false;
            }
            //the man is on the balance
            else if (ax > 22 ){
                turncommand.setText("Hold Still");
                directionRight = false;
                imageDirection.setImageResource(R.drawable.stop);
                random = 0;
            }
            //the man is on the balance
            else if(ax > 21){
                image.setImageResource(R.drawable.man3);
                turncommand.setText("Hold Still");
                imageDirection.setImageResource(R.drawable.stop);
                directionRight = true;
                random = 0;
            }
            //the man is slightly falling to right
            else if(ax > 4){
                image.setImageResource(R.drawable.man4);
                turncommand.setText("Turn Left");
                imageDirection.setImageResource(R.drawable.left);
                directionRight = true;
            }
            //The man is about to die by falling right
            else if(ax > -6){
                image.setImageResource(R.drawable.man5);
                turncommand.setText("Turn Left");
                imageDirection.setImageResource(R.drawable.left);
                directionRight = true;
            }
            //If the value is too low, the man dies.
            else{
                image.setImageResource(R.drawable.man0);
                turncommand.setText("Game Over");
                imageDirection.setImageResource(R.drawable.stop);
                isGame = false;
                score = 0;
            }


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
