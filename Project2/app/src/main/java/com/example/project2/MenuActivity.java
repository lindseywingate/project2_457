package com.example.project2;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.project2.R;

public class MenuActivity extends Activity {
    private EditText Search;
    private Button button;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Search = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.next);
    }

    public void search(View v) {
        String search = Search.getText().toString();
        new SearchActivity(this).execute(search);
    }

    public void profile(View v) {
        new ProfileActivity(this).execute();
    }

    public void logout(View v) {

    }

/*    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater( ).inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        final EditText search = (EditText) findViewById( R.id.search );
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId( );

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true;
        }
        else if ( id == R.id.next ) {
            new SearchActivity(this).execute(search.getText( ).toString());
        }
        return super.onOptionsItemSelected( item );
    }*/
}
