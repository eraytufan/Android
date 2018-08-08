package com.google.eraytufan14.tictactoe;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by Acer on 14.07.2015.
 */


public class Game {
    //player X = 1
    //player O = 2
    //private int[][] gametable = {{0,0,0}, {0,0,0}, {0,0,0}};
   /* private int but1;
    private int but2;
    private int but3;
    private int but4;
    private int but5;
    private int but6;
    private int but7;
    private int but8;
    private int but9;*/
    //Context mContext;
    int movenumber=0;
    int begplayer =1;


    //10 elemanli array
    private int[] gametable = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int player = 1;
    //restart number = 0 ise ilk baþlayan oyuncu
    //restart number = 1 ise ilk baþlayan bilgisayar
    private int restartnumber = 0;

    //input: context ve oyuna ilk kimin baslayacagý

    public void restart(){
        if(begplayer == 1){
            begplayer=2;
            player = 2;
            restartnumber =0 ;
        }
        else{
            player =1;
            begplayer=1;
            restartnumber = 0;
        }

        for(int i=0; i<10; i++) {
            gametable[i] = 0;
        }
        movenumber=0;
    }
    public int getPlayer(){
        return player;
    }
    //changes user
    public void changeUser(){
        if(player == 1){
            player = 2;
        }

        else{
            player = 1;
        }
    }





    //oyunda hamleyi yapiyor.
    //input: number: nereye hamle yaptýðý
    public void makeMove(int number){


            gametable[number] = player;
            //this.changeUser();





    }

    //input: hangi buttona hamle yaptýðý
    //oyunda hamle yapýlýp yapýlmayacaðýna bakýyor.
    public boolean canYouPlay(int number){

        if(gametable[number] == 0){
            return true;
        }

        else{
            return false;
        }

    }

    //oyunda oynanacak hamle olup olmadýðýna bakýyor.
    //eðer hamle yoksa false dönüyor
    public boolean doesItContinue(){
        for(int i = 1; i<10; i++){
            if(gametable[i] == 0){
                return true;
            }
        }

        return false;
    }

    //returns:
    //0: oyun devam ediyor
    //1: X kazandý
    //2: O kazandý
    //3: draw
    public int didItFinish(int number){

        if(number == 1){
            if(gametable[2] == player && gametable[3] == player){
                return player;
            }
            if(gametable[4] == player && gametable[7] == player){
                return player;
            }

            if(gametable[5] == player && gametable[9] == player){
                return player;
            }


        }

        else if(number == 2){
            if(gametable[1] == player && gametable[3] == player){
                return player;
            }
            if(gametable[5] == player && gametable[8] == player){
                return player;
            }





        }

        else if(number == 3){
            if(gametable[1] == player && gametable[2] == player){
                return player;
            }
            if(gametable[6] == player && gametable[9] == player){
                return player;
            }

            if(gametable[5] == player && gametable[7] == player){
                return player;
            }

        }

        else if(number == 4){
            if(gametable[5] == player && gametable[6] == player){
                return player;
            }
            if(gametable[1] == player && gametable[7] == player){
                return player;
            }



        }

        else if(number == 5){
            if(gametable[1] == player && gametable[9] == player){
                return player;
            }
            if(gametable[2] == player && gametable[8] == player){
                return player;
            }

            if(gametable[3] == player && gametable[7] == player){
                return player;
            }

            if(gametable[4] == player && gametable[6] == player){
                return player;
            }


        }

        else if(number == 6){

            if(gametable[3] == player && gametable[9] == player){
                return player;
            }

            if(gametable[4] == player && gametable[5] == player){
                return player;
            }



        }

        else if(number == 7){

            if(gametable[1] == player && gametable[4] == player){
                return player;
            }

            if(gametable[3] == player && gametable[5] == player){
                return player;
            }

            if(gametable[8] == player && gametable[9] == player){
                return player;
            }

        }

        else if(number == 8){

            if(gametable[2] == player && gametable[5] == player){
                return player;
            }

            if(gametable[7] == player && gametable[9] == player){
                return player;
            }



        }

        else if(number == 9){

            if(gametable[1] == player && gametable[5] == player){
                return player;
            }

            if(gametable[3] == player && gametable[6] == player){
                return player;
            }

            if(gametable[7] == player && gametable[8] == player){
                return player;
            }

        }

        if(doesItContinue()){

            return 0;
        }

        else{

            return 4;
        }
    }

    //1: x, oyuncu
    //2: o, artificial intelligence
    //daha bitmedi. kullanýcý rakip olunca da ayný deðerleri versin.
    public int wheretoPutEasy(){
        Random random = new Random();
        int sayi = random.nextInt(9)+1;
        while(!canYouPlay(sayi)){
            sayi = random.nextInt(9)+1;
        }

        return sayi;
    }

    public int wheretoPutNormal(){



        for(int kullanici = 2; kullanici>0; kullanici--) {
            if (canYouPlay(1)) {
                if (gametable[2] == kullanici && gametable[3] == kullanici) {
                    return 1;
                }
                if (gametable[4] == kullanici && gametable[7] == kullanici) {
                    return 1;
                }

                if (gametable[5] == kullanici && gametable[9] == kullanici) {
                    return 1;
                }


            } if (canYouPlay(2)) {
                if (gametable[1] == kullanici && gametable[3] == kullanici) {
                    return 2;
                }
                if (gametable[5] == kullanici && gametable[8] == kullanici) {
                    return 2;
                }


            } if (canYouPlay(3)) {
                if (gametable[1] == kullanici && gametable[2] == kullanici) {
                    return 3;
                }
                if (gametable[6] == kullanici && gametable[9] == kullanici) {
                    return 3;
                }

                if (gametable[5] == kullanici && gametable[7] == kullanici) {
                    return 3;
                }

            } if (canYouPlay(4)) {
                if (gametable[5] == kullanici && gametable[6] == kullanici) {
                    return 4;
                }
                if (gametable[1] == kullanici && gametable[7] == kullanici) {
                    return 4;
                }


            } if (canYouPlay(5)) {
                if (gametable[1] == kullanici && gametable[9] == kullanici) {
                    return 5;
                }
                if (gametable[2] == kullanici && gametable[8] == kullanici) {
                    return 5;
                }

                if (gametable[3] == kullanici && gametable[7] == kullanici) {
                    return 5;
                }

                if (gametable[4] == kullanici && gametable[6] == kullanici) {
                    return 5;
                }


            } if (canYouPlay(6)) {

                if (gametable[3] == kullanici && gametable[9] == kullanici) {
                    return 6;
                }

                if (gametable[4] == kullanici && gametable[5] == kullanici) {
                    return 6;
                }


            } if (canYouPlay(7)) {

                if (gametable[1] == kullanici && gametable[4] == kullanici) {
                    return 7;
                }

                if (gametable[3] == kullanici && gametable[5] == kullanici) {
                    return 7;
                }

                if (gametable[8] == kullanici && gametable[9] == kullanici) {
                    return 7;
                }

            } if (canYouPlay(8)) {

                if (gametable[2] == kullanici && gametable[5] == kullanici) {
                    return 8;
                }

                if (gametable[7] == kullanici && gametable[9] == kullanici) {
                    return 8;
                }


            } if (canYouPlay(9)) {

                if (gametable[1] == kullanici && gametable[5] == kullanici) {
                    return 9;
                }

                if (gametable[3] == kullanici && gametable[6] == kullanici) {
                    return 9;
                }

                if (gametable[7] == kullanici && gametable[8] == kullanici) {
                    return 9;
                }

            }
        }


        if(canYouPlay(5)){
            return 5;
        }

        if(canYouPlay(1) || canYouPlay(3) || canYouPlay(7) || canYouPlay(9) || canYouPlay(5)){
            Random random = new Random();
            int randomnumber = random.nextInt(4);
            int[] sayilar= {1, 3, 7, 9, 5};
            while(!canYouPlay(sayilar[randomnumber])){
                randomnumber = random.nextInt(5);
            }
            return sayilar[randomnumber];
        }

        else{
            Random random = new Random();
            int randomnumber = random.nextInt(9) + 1;
            while(!canYouPlay(randomnumber)){
                randomnumber = random.nextInt(9) + 1;
            }
            return randomnumber;
        }



    }

    public int wheretoPutHard(){



        for(int kullanici = 2; kullanici>0; kullanici--) {
            if (canYouPlay(1)) {
                if (gametable[2] == kullanici && gametable[3] == kullanici) {
                    return 1;
                }
                if (gametable[4] == kullanici && gametable[7] == kullanici) {
                    return 1;
                }

                if (gametable[5] == kullanici && gametable[9] == kullanici) {
                    return 1;
                }


            } if (canYouPlay(2)) {
                if (gametable[1] == kullanici && gametable[3] == kullanici) {
                    return 2;
                }
                if (gametable[5] == kullanici && gametable[8] == kullanici) {
                    return 2;
                }


            } if (canYouPlay(3)) {
                if (gametable[1] == kullanici && gametable[2] == kullanici) {
                    return 3;
                }
                if (gametable[6] == kullanici && gametable[9] == kullanici) {
                    return 3;
                }

                if (gametable[5] == kullanici && gametable[7] == kullanici) {
                    return 3;
                }

            } if (canYouPlay(4)) {
                if (gametable[5] == kullanici && gametable[6] == kullanici) {
                    return 4;
                }
                if (gametable[1] == kullanici && gametable[7] == kullanici) {
                    return 4;
                }


            } if (canYouPlay(5)) {
                if (gametable[1] == kullanici && gametable[9] == kullanici) {
                    return 5;
                }
                if (gametable[2] == kullanici && gametable[8] == kullanici) {
                    return 5;
                }

                if (gametable[3] == kullanici && gametable[7] == kullanici) {
                    return 5;
                }

                if (gametable[4] == kullanici && gametable[6] == kullanici) {
                    return 5;
                }


            } if (canYouPlay(6)) {

                if (gametable[3] == kullanici && gametable[9] == kullanici) {
                    return 6;
                }

                if (gametable[4] == kullanici && gametable[5] == kullanici) {
                    return 6;
                }


            } if (canYouPlay(7)) {

                if (gametable[1] == kullanici && gametable[4] == kullanici) {
                    return 7;
                }

                if (gametable[3] == kullanici && gametable[5] == kullanici) {
                    return 7;
                }

                if (gametable[8] == kullanici && gametable[9] == kullanici) {
                    return 7;
                }

            } if (canYouPlay(8)) {

                if (gametable[2] == kullanici && gametable[5] == kullanici) {
                    return 8;
                }

                if (gametable[7] == kullanici && gametable[9] == kullanici) {
                    return 8;
                }


            } if (canYouPlay(9)) {

                if (gametable[1] == kullanici && gametable[5] == kullanici) {
                    return 9;
                }

                if (gametable[3] == kullanici && gametable[6] == kullanici) {
                    return 9;
                }

                if (gametable[7] == kullanici && gametable[8] == kullanici) {
                    return 9;
                }

            }
        }

       /* if(restartnumber == 1){
            Random random = new Random();
            int randomnumb = random.nextInt(15);
            int prob[] = {1,1,2,3,3,4,5,5,5,6,7,7,8,9,9};
            restartnumber++;
            if(canYouPlay(prob[randomnumb])) {
                return prob[randomnumb];
            }
        }*/


        if (movenumber == 0) {
            movenumber++;
            int[] asdf = {1,3,7,9};
            int[] olas1 = {2,4,2,4,6,8};
            int[] olas2 = {2,6,2,4,6,8};
            int[] olas3 = {4,8,2,4,6,8};
            int[] olas4 = {6,8,2,4,6,8};
            Random random = new Random();
            int olasilik = random.nextInt(6);
            int olasilik2 = random.nextInt(4);
            if(olasilik2 == 0){
                if(canYouPlay(5)) {
                    return 5;
                }
            }
            for(int i = 0; i<4; i++) {
                if(!canYouPlay(asdf[i]) && i==0){
                    return olas1[olasilik];
                }
                else if(!canYouPlay(asdf[i]) && i==1){
                    return olas2[olasilik];
                }
                else if(!canYouPlay(asdf[i]) && i==2){
                    return olas3[olasilik];
                }
                else if(!canYouPlay(asdf[i]) && i==3){
                    return olas4[olasilik];
                }
            }

        }

        if(gametable[5] == 2 && movenumber == 1){
            if(canYouPlay(2) || canYouPlay(4) || canYouPlay(6) || canYouPlay(8)){
                Random random = new Random();
                int randomnumber = random.nextInt(4);
                int[] sayilar= {2, 4, 6, 8};
                while(!canYouPlay(sayilar[randomnumber])){
                    randomnumber = random.nextInt(4);
                }
                movenumber++;
                return sayilar[randomnumber];
            }
        }


        if(canYouPlay(1) || canYouPlay(3) || canYouPlay(7) || canYouPlay(9)){
            Random random = new Random();
            int randomnumber = random.nextInt(4);
            int[] sayilar= {1, 3, 7, 9};
            while(!canYouPlay(sayilar[randomnumber])){
                randomnumber = random.nextInt(4);
            }
            movenumber++;
            return sayilar[randomnumber];
        }

        else{
            Random random = new Random();
            int randomnumber = random.nextInt(9) + 1;
            while(!canYouPlay(randomnumber)){
                randomnumber = random.nextInt(9) + 1;
            }
            movenumber++;
            return randomnumber;
        }



    }


}
