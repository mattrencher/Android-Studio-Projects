package com.mattrencher.booksearch_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // global variables
    EditText inSearchET;
    Button sBTN;

    // declaring database
    SQLiteDatabase booksDB;

    // SQL command strings
    String SQLcreate, SQLinsert, inputSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define objects
        inSearchET = (EditText) findViewById(R.id.inputSearchET);
        sBTN = (Button) findViewById(R.id.searchBTN);

        // calling the method to create the database
        createDatabase();

        // calling the method to populate the database table
        addInitialRecords();

        // setting up a listener to the search button
        sBTN.setOnClickListener(searchButtonListener);


    } // end of oncreate

    // defining the createDatabase() method
    public void createDatabase(){
        // defining the SQLite database books DB
        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE, null);

        // create a database table
        SQLcreate = "Create table if not exists books_table(ISBN varchar "+
                "not null unique on conflict replace, title varchar," +
                "author varchar)";

        // run the SQL command
        booksDB.execSQL(SQLcreate);

    }

    // defining addInitialRecords
    public void addInitialRecords(){

        // creating SQL string to add a record
        SQLinsert = "insert into books_table values('123','Android Programming Concepts','Trish Cornez and Richard Cornez')";
        // running the SQL command
        booksDB.execSQL(SQLinsert);

        SQLinsert = "insert into books_table values('456','Learn Java by Building Android Games','John Horton')";
        // running the SQL command
        booksDB.execSQL(SQLinsert);

        SQLinsert = "insert into books_table values('789','Android Boot Camp','Corine Hoisington')";
        // running the SQL command
        booksDB.execSQL(SQLinsert);

        //Toast.makeText(this,"Records Inserted",Toast.LENGTH_SHORT).show();

    }

    // defining searchButtonListener object of the class OnCLickListener
    View.OnClickListener searchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // reading input search string
            inputSearch = inSearchET.getText().toString();

            // go to second screen to display search results
            Intent gotoShowSearch = new Intent(MainActivity.this,Results.class);

            // packing the passing variables
            gotoShowSearch.putExtra("searchKey", inputSearch);

            //ready to go to showsearch
            startActivity(gotoShowSearch);
        }
    };

}
