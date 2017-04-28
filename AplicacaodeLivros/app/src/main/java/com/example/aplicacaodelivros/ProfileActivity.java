package com.example.aplicacaodelivros;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private String usernameField, passwordField;

    //Bundle b=this.getIntent().getExtras();
    //String[] array = b.getStringArray(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedpreferences.getString("Name", "");
        String password = sharedpreferences.getString("Password", "");

        TextView textView = (TextView) findViewById(R.id.textView5);
        TextView textView1 = (TextView) findViewById(R.id.textView8);
        textView.setText(username);
        textView.setText(password);

    }
}
