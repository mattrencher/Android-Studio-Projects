package com.mattrencher.booksearchwithpic;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    // globals
    EditText inputText;
    Button sBTN;
    SQLiteDatabase booksDB;

    String SQLcreate, SQLdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining screen objects
        inputText = (EditText) findViewById(R.id.searchET);
        sBTN = (Button) findViewById(R.id.searchBTN);

        createDatabase();

        // calling the method that adds records to the database
        addInitialRecords();

        sBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reading the input text
                String inText = inputText.getText().toString();

                // creating an Intent to go to the second screen
                Intent gotoShowTitles = new Intent(MainActivity.this,ShowTitles.class);
                // packing the passing variable (inText)
                gotoShowTitles.putExtra("textKey",inText);
                // go to next screen
                startActivity(gotoShowTitles);
            }
        });

    }// end of onCreate

    public void clearDatabase() {
        String clearDBQuery = "DROP TABLE IF EXISTS books_table";
        booksDB.execSQL(clearDBQuery);
        // method to delete database
    }

    // defining method createDatabase()
    public void createDatabase(){

        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE, null);

        SQLdrop = "drop table if exists books_table";

        // now let's create it
        SQLcreate = "create table if not exists books_table(ISBN varchar " + "not null unique on conflict replace, title varchar, " +
                "author varchar, cover blob)";

        // running SQLcreate command
        booksDB.execSQL(SQLdrop);
        booksDB.execSQL(SQLcreate);
        Toast.makeText(this,"database created",Toast.LENGTH_LONG).show();
    }

    // defining method initialRecords()
    public void addInitialRecords(){
        // using ContentValues to populate the database
        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();

        // insert the values of ISBN, title, author
        values1.put("ISBN",978-1284070705);
        values2.put("title","Android Programming Concepts");
        values3.put("author","Trish Cornez and Richard Cornez");

        // first create a Bitmap from the physical image
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.and_prog_concepts);

        // create bytearrayoutputStream object
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();

        // compressing bitmap to fit database field
        bmp1.compress(Bitmap.CompressFormat.JPEG,100,bos1);

        // third, create a byte[] format object
        byte[] image1 = bos1.toByteArray();

        // now we can store the book's cover image into the database
        values1.put("cover",image1);

        // running insertion of all values
        booksDB.insert("books_table",null,values1);

        // clearing the values for values1
        values1.clear();


        // 2nd record
        // first create a Bitmap from the physical image

        // insert the values of ISBN, title, author
        values1.put("ISBN",978-1784398859);
        values2.put("title","Learning Java by Building Android Games");
        values3.put("author","John Horton");

        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.learn_java_andgames);

        // create bytearrayoutputStream object
        // ByteArrayOutputStream bos1 = new ByteArrayOutputStream();

        // compressing bitmap to fit database field
        bmp1.compress(Bitmap.CompressFormat.JPEG,100,bos1);

        // third, create a byte[] format object
        // byte[] image1 = bos1.toByteArray();

        // now we can store the book's cover image into the database
        values1.put("cover",image1);

        // running insertion of all values
        booksDB.insert("books_table",null,values1);

        Toast.makeText(this,"two insertions done",Toast.LENGTH_SHORT).show();

        // clearing the values
        //values1.clear();

        // 3nd record
        // first create a Bitmap from the physical image

        // insert the values of ISBN, title, author
        values1.put("ISBN",978-1133597209);
        values2.put("title","Android Boot Camp");
        values3.put("author","Corinne Hoisington");

        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.and_boot_camp);

        // second, create bytearrayoutputStream object
        // ByteArrayOutputStream bos1 = new ByteArrayOutputStream();

        // compressing bitmap to fit database field
        bmp1.compress(Bitmap.CompressFormat.JPEG,100,bos1);

        // third, create a byte[] format object
        // byte[] image1 = bos1.toByteArray();

        // now we can store the book's cover image into the database
        values1.put("cover",image1);

        // running insertion of all values
        booksDB.insert("books_table",null,values1);

        Toast.makeText(this,"three insertions done",Toast.LENGTH_SHORT).show();

        // 4nth record
        // first create a Bitmap from the physical image

        // insert the values of ISBN, title, author
        values1.put("ISBN",978-1934356562);
        values2.put("title","Hello Android");
        values3.put("author","Ed Burnette");

        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.hello_android);

        // create bytearrayoutputStream object
        // ByteArrayOutputStream bos1 = new ByteArrayOutputStream();

        // compressing bitmap to fit database field
        bmp1.compress(Bitmap.CompressFormat.JPEG,100,bos1);

        // third, create a byte[] format object
        // byte[] image1 = bos1.toByteArray();

        // now we can store the book's cover image into the database
        values1.put("cover",image1);

        // running insertion of all values
        booksDB.insert("books_table",null,values1);

        Toast.makeText(this,"four insertions done",Toast.LENGTH_SHORT).show();

        // clearing the values
        //values1.clear();
    }
}
