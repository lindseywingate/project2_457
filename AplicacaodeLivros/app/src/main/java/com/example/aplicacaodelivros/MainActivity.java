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
    //not needed but keeping anyway. from original practice activity
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";
    //needed
    private EditText usernameField, passwordField;

    @Override
    //identify fields where you are pulling in info from user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText)findViewById(R.id.editText);
        passwordField = (EditText)findViewById(R.id.editText2);
    }

    public void loginGet (View view) {
        //get what was entered - start signin.
        Intent intent = new Intent(this, HomepageActivity.class);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
        //new SigninActivity(this).execute(username, password);
    }
}
