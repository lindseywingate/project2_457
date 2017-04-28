/**This is the page that is viewed once the user has logged in*/
package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                new ProfileTask().execute();
            }
        });

        //search = (EditText)findViewById(R.id.editText); //setup variable
    }

    public void Go(View view) {

    }

    //public void Edit(View view) {
        //this.startActivity(new Intent(this, ProfileActivity.class));
    //}

    public void Viewcart(View view) {
        //
    }

    public void Logout(View view) {
        setContentView(R.layout.activity_main);
    }

    private class ProfileTask extends AsyncTask<String, Void, String> {
        private Context context;

        protected void onpreExecute() {} //parent class

        @Override //do not want to call parent method. use super if you want both
        protected String doInBackground(String... arg0) {
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
                return sb.toString();
            }
            catch(Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) { //result of background computation passed here after doneif (result!=null) { //if returns with data, entry exists. login successful
            super.onPostExecute(result);
            Intent newintent = new Intent();
            newintent.setClass(context, SearchResultsActivity.class);
            context.startActivity(newintent);
            //context.startActivity(new Intent(context, SearchResultsActivity.class));
        }
    }
}
