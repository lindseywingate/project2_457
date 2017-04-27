package com.example.aplicacaodelivros;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ProfileActivity extends AsyncTask<String, Void, String> {
    private Context context;
    public static final String KEY = "com.example.aplicacaodelivros.USERNAME";
    public static final String KEY2 = "com.example.aplicacaodelivros.PASSWORD";

    public ProfileActivity(Context context) {
        this.context = context;
    }

    protected void onCreate() {}

    protected void onpreExecute() {} //parent class

    @Override //do not want to call parent method. use super if you want both
    protected String doInBackground(String... arg0) {
        try {
            String username = (String) arg0[0];
            String password = (String) arg0[1];
            String link = "http://people.aero.und.edu/~lwingate/457/2/profile_get.php";

            //get method to pass variables
            link += "?username=" + URLEncoder.encode(username, "UTF-8");
            link += "&password=" + URLEncoder.encode(password, "UTF-8");

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
            String result = sb.toString();
            return result+","+username+","+password;
        }
        catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) { //result of background computation passed here after done
        String[] split = result.split(",");
        Bundle b = new Bundle();
        b.putStringArray(null, split);
        Intent i = new Intent(context, ProfileResultsActivity.class);
        i.putExtras(b);
    }
}