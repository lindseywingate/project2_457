package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.aplicacaodelivros.R.id.editText;

public class MainActivity extends Activity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";
    private EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText)findViewById(R.id.editText);
        passwordField = (EditText)findViewById(R.id.editText2);
    }

    public void loginGet (View view) {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        new SigninActivity(this).execute(username, password);
    }
}
