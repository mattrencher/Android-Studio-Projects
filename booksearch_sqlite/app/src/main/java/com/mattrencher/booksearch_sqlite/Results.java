package com.mattrencher.booksearch_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    // global values
    SQLiteDatabase booksDB;

    // declare an object of the class Cursor
    Cursor c;

    TextView outputTV;

    String userSearchWord = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        outputTV = (TextView) findViewById(R.id.resultTV);

        // let's call a method to open the database for CRUD operation
        openDatabase();

        // getting the passing input search string
        // need to create intent to do it
        Intent getVar = getIntent();

        userSearchWord = getVar.getExtras().getString("searchKey");

        String SQLselect = "select * from books_table where ISBN like '%" + userSearchWord +
                "%' or title like '%" +userSearchWord+ "%' or author like '%" + userSearchWord+ "%'";

        // running the query
        c = booksDB.rawQuery(SQLselect,null);

        // number of matching records
        int x = c.getCount();

        // create output string with all possible matching records
        String outputString = "";


        // now, let's display the matching records (if any)
        if(x != 0)
            if (c.moveToFirst()) {
                for (int i = 0; i < x; i++) {
                    // getting the fields values
                    int mISBN = c.getInt(0);
                    String mTitle = c.getString(1);
                    String mAuthor = c.getString(2);

                    outputString += "ISBN: " + mISBN + "\nTitle: " + mTitle + "\nAuthor: " + mAuthor + "\n";

                    if (!c.isLast()) {
                        c.moveToNext();
                    }
                }// end of for loop

                outputTV.setText(outputString);
            }
        else
            outputTV.setText("No records found");

    }// end of onCreate

    // defining method openDatabase;
    public void openDatabase()
    {
        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);
    }


}
