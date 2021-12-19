package com.example.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Category extends AppCompatActivity {
    Spinner spinner;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String[] cat = {"Role-playing","Shooters (FPS and TPS)","Real-Time strategy ","MMORPG"};

        spinner = findViewById(R.id.product_spinner);
        button = findViewById(R.id.cat_button);

        ArrayAdapter<String> c=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, cat);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(c);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), qnty.class);
                            String n = "1" ;
                            i.putExtra("list",n);
                            startActivity(i);
                        }
                    });
                }
                if (i==1){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), qnty.class);
                            String n = "2";
                            i.putExtra("list",n);
                            startActivity(i);

                        }
                    });

                }
                if (i==2){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), qnty.class);
                            String n = "3";
                            i.putExtra("list",n);
                            startActivity(i);
                        }
                    });

                }
                if (1==3){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), qnty.class);
                            String n = "4";
                            i.putExtra("list",n);
                            startActivity(i);
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

            Intent s = new Intent(getApplicationContext(), qnty.class);
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