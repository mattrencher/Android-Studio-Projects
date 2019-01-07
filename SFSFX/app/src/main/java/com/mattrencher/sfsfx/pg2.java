package com.mattrencher.sfsfx;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class pg2 extends AppCompatActivity {

    Button you, win, lose, perfect, finale, round, fight, six;
    Button country, announcer, character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg2);

        you = (Button) findViewById(R.id.btn1);
        win = (Button) findViewById(R.id.btn2);
        lose = (Button) findViewById(R.id.btn3);
        perfect = (Button) findViewById(R.id.btn4);
        finale = (Button) findViewById(R.id.btn5);
        round = (Button) findViewById(R.id.btn6);
        fight = (Button) findViewById(R.id.btn7);
        six = (Button) findViewById(R.id.btn8);

        country = (Button) findViewById(R.id.menu1);
        announcer = (Button) findViewById(R.id.menu2);
        character = (Button) findViewById(R.id.menu3);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.ayou);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.awin);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.alose);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.aperfect);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.finale);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.around);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.afight);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.six);


        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.seekTo(0);
                mp1.start();
            }
        });

        win.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp2.seekTo(0);
                mp2.start();
            }
        });

        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.seekTo(0);
                mp3.start();
            }
        });

        perfect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp4.seekTo(0);
                mp4.start();
            }
        });

        finale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp5.seekTo(0);
                mp5.start();
            }
        });

        round.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp6.seekTo(0);
                mp6.start();
            }
        });

        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp7.seekTo(0);
                mp7.start();
            }
        });

        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp8.seekTo(0);
                mp8.start();
            }
        });

        country.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotocountry;
                gotocountry = new Intent(pg2.this,MainActivity.class);
                startActivity(gotocountry);
            }
        });

        character.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotocharacter;
                gotocharacter = new Intent(pg2.this,pg3.class);
                startActivity(gotocharacter);
            }
        });
    }
}
