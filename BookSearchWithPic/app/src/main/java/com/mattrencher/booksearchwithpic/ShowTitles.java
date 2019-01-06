package com.mattrencher.booksearchwithpic;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ShowTitles extends AppCompatActivity {
    // global variables
    ListView matchbooksLV;

    SQLiteDatabase booksDB;

    String searchWord, mISBN, mTitle, mAuthor, showInfo;
    String[] matchISBN, matchTitle, matchAuthor;

    Cursor pointer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_titles);

        // creating intent to get inputText
        Intent getVars = getIntent();

        // getting the search word
        searchWord = getVars.getExtras().getString("textKey");

        // Toast.makeText(ShowTitles.this,"Entered Text:" + searchWord,Toast.LENGTH_LONG).show();
        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);

        // creating a SQL string to retrieve records that match the searchWord
        String SQLselect = "select * from books_table where ISBN like '%" + searchWord + "%' or title like '%" + searchWord +"%' or "
                + "author like '%" + searchWord+"%'";

        // running SQLselect
        // first defining a cursor object
        pointer = booksDB.rawQuery(SQLselect,null);

        // number of matching records if any
        int numrecs = pointer.getCount();

        // matching array index
        int mx = 0;
        boolean foundrecs = false;

        if (numrecs != 0)
        {
            matchISBN = new String[numrecs];
            matchTitle = new String[numrecs];
            matchAuthor = new String[numrecs];
            matchbooksLV = (ListView) findViewById(R.id.resultLV);

            // getting all matching fields values
            while(pointer.moveToNext())
            {
                matchISBN[mx] = pointer.getString(0);
                matchTitle[mx] = pointer.getString(1);
                matchAuthor[mx] = pointer.getString(2);
            }

            // populating the ListView twith the matching records
            // defining the ArrayAdapter of the ListView
            ArrayAdapter<String> resultAA = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,matchTitle);

            // setting up the adapter to the listview
            matchbooksLV.setAdapter(resultAA);

            // setting up a listener to the listview
            matchbooksLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // defining String showInfo that will be passed to the third screen
                    showInfo = "ISBN: " + matchISBN[position] + "\nTitle: " +
                            matchTitle[position] + "\nAuthor: " +
                            matchAuthor[position];

                    // creating Intent to go to third screen, ShowBook

                    Intent gotoShowBook = new Intent(ShowTitles.this,ShowBook.class);
                    // packing Intent with the variable showInfo
                    gotoShowBook.putExtra("infoKey", showInfo);
                    gotoShowBook.putExtra("isbnKey", matchISBN[position]);

                    // start activity ShowBook
                    startActivity(gotoShowBook);


                }
            });
        }

    }
}
