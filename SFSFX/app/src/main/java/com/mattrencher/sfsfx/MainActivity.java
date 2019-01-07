package com.mattrencher.sfsfx;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button japan, ussr, china, thailand, india, spain, usa, brazil;
    Button country, announcer, character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        japan = (Button) findViewById(R.id.btn1);
        ussr = (Button) findViewById(R.id.btn2);
        china = (Button) findViewById(R.id.btn3);
        thailand = (Button) findViewById(R.id.btn4);
        india = (Button) findViewById(R.id.btn5);
        spain = (Button) findViewById(R.id.btn6);
        usa = (Button) findViewById(R.id.btn7);
        brazil = (Button) findViewById(R.id.btn8);

        country = (Button) findViewById(R.id.menu1);
        announcer = (Button) findViewById(R.id.menu2);
        character = (Button) findViewById(R.id.menu3);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.japan);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.ussr);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.china);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.thailand);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.india);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.spain);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.usa);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.brazil);


        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.seekTo(0);
                mp1.start();
            }
        });

        ussr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp2.seekTo(0);
                mp2.start();
            }
        });

        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.seekTo(0);
                mp3.start();
            }
        });

        thailand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp4.seekTo(0);
                mp4.start();
            }
        });

        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp5.seekTo(0);
                mp5.start();
            }
        });

        spain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp6.seekTo(0);
                mp6.start();
            }
        });

        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp7.seekTo(0);
                mp7.start();
            }
        });

        brazil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp8.seekTo(0);
                mp8.start();
            }
        });

        announcer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotoannouncer = new Intent(MainActivity.this,pg2.class);
                startActivity(gotoannouncer);
            }
        });

        character.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotocharacter = new Intent(MainActivity.this,pg3.class);
                startActivity(gotocharacter);
            }
        });

    }
}
