package com.mattrencher.booksearchwithpic;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowBook extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book);

        // defining objects
        TextView outTV = (TextView) findViewById(R.id.outputTV);
        ImageView outIV = (ImageView) findViewById(R.id.coverIV);

        // getting variables
        Intent getVars = getIntent();

        String bookdata = getVars.getExtras().getString("infoKey");
        String mISBN = getVars.getExtras().getString("isbnKey");

        // open database
        SQLiteDatabase booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);

        // creating a SQLselect string
        String SQLselect = "select * from books_table where ISBN like '%" + mISBN + "%'";

        Cursor cursor = booksDB.rawQuery(SQLselect,null);

        cursor.moveToNext();
        byte[] image = cursor.getBlob(3);

        Bitmap bmp = BitmapFactory.decodeByteArray(image,0,image.length);

        // displaying bookdata in textview
        outTV.setText(bookdata);

        // displaying book cover image
        outIV.setImageBitmap(bmp);
    }
}
