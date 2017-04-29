package com.example.bookapp;

import android.app.Activity;
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

public class LoginActivity extends AsyncTask<String, Void, String> {
    private Context context;

    public LoginActivity(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String ... arg0) {
        String username = (String) arg0[0];
        String password = (String) arg0[1];

        try {
            String link = "http://people.aero.und.edu/~lwingate/457/2/login_get.php";

            //get method
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
            return sb.toString();
        }
        catch(Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(result!="false") {
            context.startActivity(new Intent(context, Homepage.class));
        }
    }
}
