package com.example.project2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText usernameField, passwordField;
    private TextView status, role, method;

    int val=2;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        usernameField = (EditText) findViewById( R.id.editText1 );
        passwordField = (EditText) findViewById( R.id.editText2 );
        status = (TextView) findViewById( R.id.textView6 );
        role   = (TextView) findViewById( R.id.textView7 );
        method = (TextView) findViewById( R.id.textView9 );

    }

    // Called when the button LOGIN-GET is pushed
    public void loginGet( View view ) {
        String username = usernameField.getText( ).toString( );
        String password = passwordField.getText( ).toString( );
        //add username and password to shared preferences
        SharedPreferences sp = getSharedPreferences("stuff", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
        val=sp.getInt("VALIDATION", val);
        method.setText( "Get Method" );
        new SigninActivity( this, status, role, 0 ).execute( username, password );

    }

}
