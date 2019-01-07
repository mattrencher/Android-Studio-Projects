// Matthew Rencher
// Android Final Exam
// Prof Pinto

package com.mattrencher.stateTaxCalc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase taxDB;
    EditText inPurchase, inState;
    Button subBTN;

    Double purchase;
    String state;
    String SQLcreate, SQLinsert, outputTax;

    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inPurchase = (EditText) findViewById(R.id.purchaseET);
        inState = (EditText) findViewById(R.id.stateET);
        subBTN = (Button) findViewById(R.id.sBTN);

        createDatabase();

        addInitialRecords();

        subBTN.setOnClickListener(searchButtonListener);

    }

    public void createDatabase(){
        taxDB = openOrCreateDatabase("tax", Context.MODE_PRIVATE, null);

        SQLcreate = "Create table if not exists tax_table(state varchar(2), tax double)";

        taxDB.execSQL(SQLcreate);
    }

    public void addInitialRecords(){
        SQLinsert = "insert into tax_table values('OR',5)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('MD',7)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('NJ',7)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('CO',8)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('NY',8.875)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('IN',9)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('AL',10)";
        taxDB.execSQL(SQLinsert);

        SQLinsert = "insert into tax_table values('IL',11.5)";
        taxDB.execSQL(SQLinsert);

        Toast.makeText(this,"Records Inserted", Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener searchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // reading inputs
            purchase = Double.parseDouble(inPurchase.getText().toString());
            state = inState.getText().toString().trim();

            //Toast.makeText(MainActivity.this,"State:"+state+" Tax:"+purchase, Toast.LENGTH_SHORT).show();

            String SQLselect = "select tax from tax_table where state = '"+state+"'";

            c = taxDB.rawQuery(SQLselect,null);
            c.moveToFirst();
            Double taxRate = c.getDouble(0);
            Double totalTax = (taxRate*.01) * purchase;
            Double total = totalTax + purchase;

            Toast.makeText(MainActivity.this,"Total including tax: $"+total, Toast.LENGTH_SHORT).show();
        }
    };
}
