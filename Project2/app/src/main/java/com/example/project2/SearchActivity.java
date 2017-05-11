package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchActivity extends AsyncTask<String, Void, String> {
    private Context context;
    public SearchActivity activity;

    // Flag 0 means GET and 1 means POST. (By default it is GET.)
    public SearchActivity(Context context) {
        this.context = context;
    }

    public SearchActivity(Class<MenuActivity> menuActivityClass) {

    }

    protected void onPreExecute() { }

    @Override
    protected String doInBackground( String... arg0 ) {
        try {
            String search = (String) arg0[0];
            String link = "http://people.aero.und.edu/~lwingate/457/2/book_get.php";
            link += "?book=" + URLEncoder.encode( search, "UTF-8" );

            // Connect to the server.
            URL url = new URL(link);
            URLConnection conn = url.openConnection( );
            conn.setDoOutput(true);

            // Read server response.
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder( );
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            return sb.toString( );
        }
        catch( Exception e ) {
            return new String( "Exception: " + e.getMessage( ) );
        }
    }

    @Override
    protected void onPostExecute(String results) {
        Intent intent_name = new Intent();
        intent_name.setClass(context, SearchResultsActivity.class);
        intent_name.putExtra("key", results);
        context.startActivity(intent_name);
    }
}