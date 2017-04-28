package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.aplicacaodelivros.R.id.editText;
import static com.example.aplicacaodelivros.R.id.icon;

public class MainActivity extends Activity {
    EditText usernameField, passwordField;
    Button button;

    SharedPreferences sharedpreferences;

    @Override
    //identify fields where you are pulling in info from user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginGet (View view) {
        usernameField = (EditText)findViewById(R.id.editText);
        passwordField = (EditText)findViewById(R.id.editText2);
        String username = usernameField.getEditableText().toString();
        String password = passwordField.getEditableText().toString();

        if(username.equals("customer") && password.equals("testing")) {
            setContentView(R.layout.activity_homepage);
        }
        else {
            TextView incorrectlogin = (TextView) findViewById(R.id.incorrectlogin);
            incorrectlogin.setText("Incorrect Login");
        }
    }
}
