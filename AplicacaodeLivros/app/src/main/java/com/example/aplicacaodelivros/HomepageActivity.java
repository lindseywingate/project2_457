package com.example.aplicacaodelivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.aplicacaodelivros.R.id.editText;

public class HomepageActivity extends AppCompatActivity {
    private Button Go, View, Edit, Logout;
    private EditText search;
    public static final String KEY = "com.example.aplicacaodelivros.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        search = (EditText)findViewById(R.id.editText); //setup variable
        Intent intent = getIntent();
    }

    public void Go(View view) {
        String title = search.getText().toString(); //get search entered
        new SearchActivity(this).execute(title); //send to mysql/php scripts

    }

    public void Profile(View view) {
        //
    }

    public void Viewcart(View view) {
        //
    }

    public void Logout(View view) {
        setContentView(R.layout.activity_main);

    }
}
