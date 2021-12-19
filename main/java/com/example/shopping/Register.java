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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText email, username, password;
    ImageButton button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        button = findViewById(R.id.register_button);

        db = openOrCreateDatabase("Mydata", Context.MODE_PRIVATE,null);
        db.execSQL("Create Table If Not Exists userinfo(username varchar, password varchar, email varchar);");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String q = "Insert into userinfo Values('"+username.getText().toString()+"','"+password.getText().toString()+"','"+email.getText().toString()+"')";
                    db.execSQL(q);
                    Toast.makeText(getApplicationContext(),"user " + username.getText()+ " Added!", Toast.LENGTH_LONG).show();
                    username.getText().clear();
                    password.getText().clear();
                    email.getText().clear();

                    Intent login = new Intent(getApplicationContext(), Login.class);
                    startActivity(login);

                }
                catch (Exception e){

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login) {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);

        }

        if (id == R.id.register) {
            Intent r = new Intent(getApplicationContext(), Register.class);
            startActivity(r);

        }
        return super.onOptionsItemSelected(item);
    }
}