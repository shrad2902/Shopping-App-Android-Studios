package com.example.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {
    TextView p1, p2, p3, p4, game1, game2, game3, game4, total1, total2, total3, total4, gtotal;
    EditText q1, q2, q3, q4;
    ImageButton button;
    String pp1;
    String pp2;
    String pp3;
    String pp4;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        p1 = findViewById(R.id.bprice1);
        p2 = findViewById(R.id.bprice2);
        p3 = findViewById(R.id.bprice3);
        p4 = findViewById(R.id.price4);
        q1 = findViewById(R.id.bqnty1);
        q2 = findViewById(R.id.bqnty2);
        q3 = findViewById(R.id.bqnty3);
        q4 = findViewById(R.id.cqnty4);
        game1 = findViewById(R.id.bgame1);
        game2 = findViewById(R.id.bgame2);
        game3 = findViewById(R.id.bgame3);
        game4 = findViewById(R.id.bgame4);
        total1 = findViewById(R.id.ctotal1);
        total2 = findViewById(R.id.ctotal2);
        total3 = findViewById(R.id.ctotal3);
        total4 = findViewById(R.id.ctotal4);
        gtotal = findViewById(R.id.gtotal);
        button = findViewById(R.id.cbutton);

        q1.setVisibility(View.INVISIBLE);
        q2.setVisibility(View.INVISIBLE);
        q3.setVisibility(View.INVISIBLE);
        q4.setVisibility(View.INVISIBLE);

        db = openOrCreateDatabase("Shopping", Context.MODE_PRIVATE, null);
        db.execSQL("Create table If not Exists ProductInfo(Name Varchar, Price Int)");
        db.execSQL("Create table If not Exists PriceInfo(qnty Varchar, subprice Varchar)");

        String query = "select * from ProductInfo";
        Cursor sql = db.rawQuery(query, null);

        try {
            sql.moveToFirst();
            game1.setText(sql.getString(0));
            p1.setText(sql.getString(1));
            pp1 = sql.getString(1);
            total1.setText(pp1);

            sql.moveToNext();
            game2.setText(sql.getString(0));
            p2.setText( sql.getString(1));
            pp2 = sql.getString(1);
            total2.setText(pp2);

            sql.moveToNext();
            game3.setText(sql.getString(0));
            p3.setText(sql.getString(1));
            pp3 = sql.getString(1);
            total3.setText(pp3);

            sql.moveToNext();
            game4.setText(sql.getString(0));
            p4.setText(sql.getString(1));
            pp4 = sql.getString(1);
            total4.setText(pp4);

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

        int possiblet1 = 0;
        int possiblet2 = 0;
        int possiblet3 = 0;
        int possiblet4 = 0;

        try {
            possiblet1 = Integer.parseInt(total1.getText().toString());
            possiblet2 = Integer.parseInt(total2.getText().toString());
            possiblet3 = Integer.parseInt(total3.getText().toString());
            possiblet4 = Integer.parseInt(total4.getText().toString());
            int T = possiblet1 + possiblet2 + possiblet3 + possiblet4;
            gtotal.setText(""+T+"");
        }
        catch (Exception whTy){
            int T = possiblet1 + possiblet2 + possiblet3 + possiblet4;
            gtotal.setText(""+T+"");
        }

        q1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                int Q1 = 0;
                try {
                    if (editable == null) {
                        Q1 = 0;
                    } else {
                        Q1 = Integer.parseInt(editable.toString());
                    }
                } catch (Exception WHyt) {
                    Toast.makeText(getApplicationContext(), "Add a Digit", Toast.LENGTH_SHORT).show();
                }
                int P1 = Integer.parseInt(pp1);
                int tempTotal = Q1 * P1;
                total1.setText("" + tempTotal + "");

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
                    gtotal.setText(""+T+"");
                }
                catch (Exception whTy){
//                    Toast.makeText(getApplicationContext(),whTy.toString() ,Toast.LENGTH_SHORT).show();
                }

            }
        });

        q2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                int Q2 = 0;
                try {
                    if(editable == null) {
                        Q2 = 0;
                    }
                    else {
                        Q2 = Integer.parseInt(editable.toString());
                    }
                }
                catch (Exception WHyt) {
                    Toast.makeText(getApplicationContext(), "Add a Digit", Toast.LENGTH_SHORT).show();
                }

                int P2 = Integer.parseInt(pp2);
                int tempTotal = Q2 * P2;
                total2.setText("" + tempTotal + "");

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
                    gtotal.setText(""+T+"");
                }
                catch (Exception whTy){
                    int T = possible1 + possible2 + possible3 + possible4;
                    gtotal.setText(""+T+"");
                }

            }
        });

        q3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                int Q3 = 0;
                try {
                    if(editable == null) {
                        Q3 = 0;
                    }
                    else {
                        Q3 = Integer.parseInt(editable.toString());
                    }
                }
                catch (Exception WHyt) {
                    Toast.makeText(getApplicationContext(), "Add a Digit", Toast.LENGTH_SHORT).show();
                }

                int P3 = Integer.parseInt(pp3);
                int tempTotal1 = Q3 * P3;
                total3.setText("" + tempTotal1 + "");

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
                    gtotal.setText(""+T+"");
                }
                catch (Exception whTy){
                    int T = possible1 + possible2 + possible3 + possible4;
                    gtotal.setText(""+T+"");
                }
            }
        });

        q4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                int Q4 = 0;
                try {
                    if(editable == null) {
                        Q4= 0;
                    }
                    else {
                        Q4 = Integer.parseInt(editable.toString());
                    }
                }
                catch (Exception WHyt) {
                    Toast.makeText(getApplicationContext(), "Add a Digit", Toast.LENGTH_SHORT).show();
                }

                int P4 = Integer.parseInt(pp4);
                int tempTotal2 = Q4 * P4;
                total4.setText("" + tempTotal2 + "");
                gtotal.setText(""+ tempTotal2 + "");

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
                    gtotal.setText(""+T+"");
                }
                catch (Exception whTy){
                    int T = possible1 + possible2 + possible3 + possible4;
                    gtotal.setText(""+T+"");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String A = "Insert into PriceInfo Values('" + q1.getText().toString() + "','" + total1.getText().toString() + "')";
                db.execSQL(A);

                String B = "Insert into PriceInfo Values('" + q2.getText().toString() + "','" + total2.getText().toString() + "')";
                db.execSQL(B);

                String C = "Insert into PriceInfo Values('" + q3.getText().toString() + "','" + total3.getText().toString() + "')";
                db.execSQL(C);

                String D = "Insert into PriceInfo Values('" + q4.getText().toString() + "','" + total4.getText().toString() + "')";
                db.execSQL(D);

                Intent i = new Intent(getApplicationContext(), Bill.class);
                startActivity(i);

            }
        });
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