package com.example.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Bill extends AppCompatActivity {
    SQLiteDatabase db;
    TextView p1, p2, p3, p4, game1, game2, game3, game4, total1, total2, total3, total4, total, q1, q2, q3, q4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        game1 = findViewById(R.id.bgame1);
        game2 = findViewById(R.id.bgame2);
        game3 = findViewById(R.id.bgame3);
        game4 = findViewById(R.id.bgame4);
        p1 = findViewById(R.id.bprice1);
        p2 = findViewById(R.id.bprice2);
        p3 = findViewById(R.id.bprice3);
        p4 = findViewById(R.id.bprice4);
        total = findViewById(R.id.btotal);
        total1 = findViewById(R.id.btotal1);
        total2 = findViewById(R.id.btotal2);
        total3 = findViewById(R.id.btotal3);
        total4 = findViewById(R.id.btotal4);
        q1 = findViewById(R.id.bqnty1);
        q2 = findViewById(R.id.bqnty2);
        q3 = findViewById(R.id.bqnty3);
        q4 = findViewById(R.id.bqnty4);

        q1.setVisibility(View.INVISIBLE);
        q2.setVisibility(View.INVISIBLE);
        q3.setVisibility(View.INVISIBLE);
        q4.setVisibility(View.INVISIBLE);

        db = openOrCreateDatabase("Shopping", Context.MODE_PRIVATE, null);
        db.execSQL("Create table If not Exists ProductInfo(Name Varchar, Price Int)");
        db.execSQL("Create table If not Exists PriceInfo(qnty Varchar, subprice Int)");

        String query = "select * from ProductInfo";
        Cursor sql = db.rawQuery(query, null);

        try {
            sql.moveToFirst();
            game1.setText(sql.getString(0));
            p1.setText(sql.getString(1));

            sql.moveToNext();
            game2.setText(sql.getString(0));
            p2.setText( sql.getString(1));

            sql.moveToNext();
            game3.setText(sql.getString(0));
            p3.setText(sql.getString(1));

            sql.moveToNext();
            game4.setText(sql.getString(0));
            p4.setText(sql.getString(1));

        }
        catch (Exception e){

        }

        String query1 = "select * from PriceInfo";
        Cursor Sql = db.rawQuery(query1, null);

        try {
            Sql.moveToFirst();
            q1.setText(Sql.getString(0));
            total1.setText(Sql.getString(1));

            Sql.moveToNext();
            q2.setText(Sql.getString(0));
            total2.setText( Sql.getString(1));

            Sql.moveToNext();
            q3.setText(Sql.getString(0));
            total3.setText(Sql.getString(1));

            Sql.moveToNext();
            q4.setText(Sql.getString(0));
            total4.setText(Sql.getString(1));

        }
        catch (Exception e){

        }

        if (!(game1.getText().toString().isEmpty())) {
            q1.setVisibility(View.VISIBLE);

        }
        if (!(game2.getText().toString().isEmpty())) {
            q2.setVisibility(View.VISIBLE);

        }
        if (!(game3.getText().toString().isEmpty())) {
            q3.setVisibility(View.VISIBLE);

        }
        if (!(game4.getText().toString().isEmpty())) {
            q4.setVisibility(View.VISIBLE);

        }

        int possible1 = 0;
        int possible2 = 0;
        int possible3 = 0;
        int possible4 = 0;

        try {
            possible1 = Integer.parseInt(total1.getText().toString());
            possible2 = Integer.parseInt(total2.getText().toString());
            possible3 = Integer.parseInt(total3.getText().toString());
            possible4 = Integer.parseInt(total4.getText().toString());
            int T = possible1 + possible2 + possible3 + possible4;
            total.setText("Rs."+T+"");
        }
        catch (Exception whTy){
            int T = possible1 + possible2 + possible3 + possible4;
            total.setText("Rs."+T+"");
        }

        db.execSQL("drop table PriceInfo");
        db.execSQL("drop table ProductInfo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cart) {

            Intent s = new Intent(getApplicationContext(), Cart.class);
            startActivity(s);

        }
        if (id == R.id.bill) {

            Intent u = new Intent(getApplicationContext(), Bill.class);
            startActivity(u);

        }
        if (id == R.id.product) {

            Intent d = new Intent(getApplicationContext(), Category.class);
            startActivity(d);

        }
        return super.onOptionsItemSelected(item);
    }
}