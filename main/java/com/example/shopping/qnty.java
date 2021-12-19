package com.example.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class qnty extends AppCompatActivity {
    CheckBox item1, item2, item3, item4;
    TextView p1, p2, p3, p4;
    ImageButton button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qnty);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        button = findViewById(R.id.button);

        String s="0";

        db = openOrCreateDatabase("Shopping", Context.MODE_PRIVATE, null);
        db.execSQL("Create table If not Exists ProductInfo(Name Varchar, Price Int)");
        Bundle bundle = getIntent().getExtras();
        try {
            s = bundle.getString("list");
        } catch (Exception e) {
            s = "0";
            Toast.makeText(getApplicationContext(), "Exception =" + e + "", Toast.LENGTH_SHORT).show();
        }
        switch (s) {

            case "1":
                String aItem1 = "Witcher 3";
                int aP1 = 800;
                String aItem2 = "Elden Ring";
                int aP2 = 3999;
                String aItem3 = "God of War";
                int aP3 = 3299;
                String aItem4 = "Dark souls";
                int aP4 = 1199;
                item1.setText(aItem1);
                p1.setText("Rs." + aP1);
                item2.setText(aItem2);
                p2.setText("Rs." + aP2);
                item3.setText(aItem3);
                p3.setText("Rs." + aP3);
                item4.setText(aItem4);
                p4.setText("Rs." + aP4);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item1.isChecked()) {
                            String A = "Insert into ProductInfo Values('" + aItem1 + "','" + aP1 + "')";
                            db.execSQL(A);
                        }
                        if (item2.isChecked()) {
                            String B = "Insert into ProductInfo Values('" + aItem2 + "','" + aP2 + "')";
                            db.execSQL(B);
                        }
                        if (item3.isChecked()) {
                            String C = "Insert into ProductInfo Values('" + aItem3 + "','" + aP3 + "')";
                            db.execSQL(C);
                        }
                        if (item4.isChecked()) {
                            String D = "Insert into ProductInfo Values('" + aItem4 + "','" + aP4 + "')";
                            db.execSQL(D);
                        }
                        Intent c = new Intent(getApplicationContext(), Cart.class);
                        startActivity(c);
                    }
                });

            break;

            case "2":
                String bItem1 = "Destiny";
                int bP1 = 999;
                String bItem2 = "COD";
                int bP2 = 3999;
                String bItem3 = "Battlefield 2042";
                int bP3 = 2999;
                String bItem4 = "Boom Eternal";
                int bP4 = 3999;
                item1.setText(bItem1);
                p1.setText("Rs." + bP1);
                item2.setText(bItem2);
                p2.setText("Rs." + bP2);
                item3.setText(bItem3);
                p3.setText("Rs." + bP3);
                item4.setText(bItem4);
                p4.setText("Rs." + bP4);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item1.isChecked()) {
                            String A = "Insert into ProductInfo Values('" + bItem1 + "','" + bP1 + "')";
                            db.execSQL(A);
                        }
                        if (item2.isChecked()) {
                            String B = "Insert into ProductInfo Values('" + bItem2 + "','" + bP2 + "')";
                            db.execSQL(B);
                        }
                        if (item3.isChecked()) {
                            String C = "Insert into ProductInfo Values('" + bItem3 + "','" + bP3 + "')";
                            db.execSQL(C);
                        }
                        if (item4.isChecked()) {
                            String D = "Insert into ProductInfo Values('" + bItem4 + "','" + bP4 + "')";
                            db.execSQL(D);
                        }
                        Intent c = new Intent(getApplicationContext(), Cart.class);
                        startActivity(c);
                    }
                });

            break;

            case "3":
                String cItem1 = "Warcraft 3";
                int cP1 = 2100;
                String cItem2 = "Starcarft 2 ";
                int cP2 = 562;
                String cItem3 = "Age of Empires 2";
                int cP3 = 8109;
                String cItem4 = "Rise of Nations";
                int cP4 = 590;
                item1.setText(cItem1);
                p1.setText("Rs." + cP1);
                item2.setText(cItem2);
                p2.setText("Rs." + cP2);
                item3.setText(cItem3);
                p3.setText("Rs." + cP3);
                item4.setText(cItem4);
                p4.setText("Rs." + cP4);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item1.isChecked()) {
                            String A = "Insert into ProductInfo Values('" + cItem1 + "','" + cP1 + "')";
                            db.execSQL(A);
                        }
                        if (item2.isChecked()) {
                            String B = "Insert into ProductInfo Values('" + cItem2 + "','" + cP2 + "')";
                            db.execSQL(B);
                        }
                        if (item3.isChecked()) {
                            String C = "Insert into ProductInfo Values('" + cItem3 + "','" + cP3 + "')";
                            db.execSQL(C);
                        }
                        if (item4.isChecked()) {
                            String D = "Insert into ProductInfo Values('" + cItem4 + "','" + cP4 + "')";
                            db.execSQL(D);
                        }
                        Intent c = new Intent(getApplicationContext(), Cart.class);
                        startActivity(c);
                    }
                });

            break;

            case "4":
                String dItem1 = "Final Fantasy 14";
                int dP1 = 8316;
                String dItem2 = "World of Warcraft";
                int dP2 = 1290;
                String dItem3 = "Guildwars 2";
                int dP3 = 3999;
                String dItem4 = "Neverwinter Nights";
                int dP4 = 1290;
                item1.setText(dItem1);
                p1.setText("Rs." + dP1);
                item2.setText(dItem2);
                p2.setText("Rs." + dP2);
                item3.setText(dItem3);
                p3.setText("Rs." + dP3);
                item4.setText(dItem4);
                p4.setText("Rs." + dP4);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item1.isChecked()) {
                            String A = "Insert into ProductInfo Values('" + dItem1 + "','" + dP1 + "')";
                            db.execSQL(A);
                        }
                        if (item2.isChecked()) {
                            String B = "Insert into ProductInfo Values('" + dItem2 + "','" + dP2 + "')";
                            db.execSQL(B);
                        }
                        if (item3.isChecked()) {
                            String C = "Insert into ProductInfo Values('" + dItem3 + "','" + dP3 + "')";
                            db.execSQL(C);
                        }
                        if (item4.isChecked()) {
                            String D = "Insert into ProductInfo Values('" + dItem4 + "','" + dP4 + "')";
                            db.execSQL(D);
                        }
                        Intent c = new Intent(getApplicationContext(), Cart.class);
                        startActivity(c);
                    }
                });

            break;

        }
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