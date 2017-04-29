/**This is the page that is viewed once the user has logged in*/
package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HomepageActivity extends Activity {
    private Button Go, View, Edit, Logout;
    private EditText search;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button editprofile = (Button) findViewById(R.id.profilebutton);
        editprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = testing();
                //TextView box = (TextView) findViewById(R.id.testing);
                //box.setText("testingggg");
            }
        });
    }

    public void Logout(View view) {
        Intent newintent = new Intent();
        newintent.setClass(this, MainActivity.class);
        this.startActivity(newintent);
    }

        protected String testing() { //parent class
            try {
                //search for phrase
                //php script to call
                String link = "http://people.aero.und.edu/~lwingate/457/2/profile_get.php";

                //get method to pass variables
                link += "?username=" + URLEncoder.encode("customer", "UTF-8");
                link += "&password=" + URLEncoder.encode("testing", "UTF-8");

                //Connect to server
                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);

                //Read server response
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                System.out.println(sb.toString());
                return sb.toString();
            }
            catch(Exception e) {
                System.out.println("Exception: " + e.getMessage());
                Log.w("Exception: ","print**** " + e.getMessage());
                return e.getMessage();

            }
            //startActivity(new Intent(this, SearchResultsActivity.class));

            //Intent newintent = new Intent();
         // newintent.setClass(context, SearchResultsActivity.class);
         //context.startActivity(newintent);
    }
}
