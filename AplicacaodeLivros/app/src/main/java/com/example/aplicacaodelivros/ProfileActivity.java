package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.OutputStreamWriter;

public class ProfileActivity extends AsyncTask<String, Void, String> {
        private Context context;

        public ProfileActivity(Context context) {
            this.context = context;
        }

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
