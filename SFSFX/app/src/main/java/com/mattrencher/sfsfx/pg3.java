package com.mattrencher.sfsfx;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pg3 extends AppCompatActivity {

    Button fire, flame, hadoken, shoryuken, sonicboom, tiger, uppercut, yoga;
    Button country, announcer, character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg3);

        tiger = (Button) findViewById(R.id.btn1);
        uppercut = (Button) findViewById(R.id.btn2);
        yoga = (Button) findViewById(R.id.btn3);
        flame = (Button) findViewById(R.id.btn4);
        fire = (Button) findViewById(R.id.btn5);
        sonicboom = (Button) findViewById(R.id.btn6);
        hadoken = (Button) findViewById(R.id.btn7);
        shoryuken = (Button) findViewById(R.id.btn8);

        country = (Button) findViewById(R.id.menu1);
        announcer = (Button) findViewById(R.id.menu2);
        character = (Button) findViewById(R.id.menu3);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.tiger);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.uppercut);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.yoga);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.flame);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.fire);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.sonicboom);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.hadoken);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.shoryuken);


        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.seekTo(0);
                mp1.start();
            }
        });

        uppercut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp2.seekTo(0);
                mp2.start();
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.seekTo(0);
                mp3.start();
            }
        });

        flame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp4.seekTo(0);
                mp4.start();
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp5.seekTo(0);
                mp5.start();
            }
        });

        sonicboom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp6.seekTo(0);
                mp6.start();
            }
        });

        hadoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp7.seekTo(0);
                mp7.start();
            }
        });

        shoryuken.setOnClickListener(new View.OnClickListener(){
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
                gotocountry = new Intent(pg3.this,MainActivity.class);
                startActivity(gotocountry);
            }
        });

        announcer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotoannouncer;
                gotoannouncer = new Intent(pg3.this,pg2.class);
                startActivity(gotoannouncer);
            }
        });
    }
}
