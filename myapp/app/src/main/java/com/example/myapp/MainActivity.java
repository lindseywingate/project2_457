package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.bookstore.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.bookstore.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendlogininfo(View view) {
        Intent intent = new Intent(this, logininfo.class); //context as parent class, new class to be called
        EditText username = (EditText) findViewById(R.id.editText);
        EditText password = (EditText) findViewById(R.id.editText2);//adds text to intent. can carry key-value pairs. keys used to grab values for next method
        String message_u = username.getText().toString();
        String message_p = password.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message_u);
        intent.putExtra(EXTRA_MESSAGE2, message_p);
        startActivity(intent); //starts instance of checklogin
    }
}
