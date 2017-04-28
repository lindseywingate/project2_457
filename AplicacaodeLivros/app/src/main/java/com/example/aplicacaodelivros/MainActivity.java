package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.aplicacaodelivros.R.id.editText;

public class MainActivity extends Activity {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Password = "passwordKey";

    EditText usernameField, passwordField;
    Button button;

    SharedPreferences sharedpreferences;
    @Override
    //identify fields where you are pulling in info from user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText)findViewById(R.id.editText);
        passwordField = (EditText)findViewById(R.id.editText2);

    }

    public void loginGet (View view) {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, usernameField.toString());
        editor.putString(Password, passwordField.toString());
        editor.commit();
        new SigninActivity(this).execute(usernameField.toString(), passwordField.toString());
    }
}
