package com.wenchen.server;

        import android.content.Context;
        import android.os.AsyncTask;
        import android.widget.TextView;
        import java.net.URL;
        import java.net.URLConnection;
        import java.net.URLEncoder;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class SigninActivity extends AsyncTask<String, Void, String> {
    private TextView statusField, roleField;
    private Context context;
    private int byGetOrPost = 0;

        // Flag 0 means GET and 1 means POST. (By default it is GET.)

    public SigninActivity( Context context, TextView statusField, TextView roleField, int flag ) {
        this.context     = context;
        this.statusField = statusField;
        this.roleField   = roleField;
        byGetOrPost      = flag;
    }

    protected void onPreExecute( ) {

    @Override
    protected String doInBackground(String arg0) {
        try {
            String username = (String) arg0[0];
            String password = (String) arg0[1];
            String link     = "http://wenchen.cs.und.edu/course/457/11/Android/";

            // Complete the URL.
            if ( byGetOrPost == 0 ) { // Get method
                link += "login_get.php";
                link += "?username=" + URLEncoder.encode( username, "UTF-8" );
                link += "&password=" + URLEncoder.encode( password, "UTF-8" );
            }
      else { // Post method
                link += "login_post.php";
            }

            // Connect to the server.
            URL            url = new URL( link );
            URLConnection conn = url.openConnection( );
            conn.setDoOutput( true );

            // Send the arguments via standard output for the POST method.
            if ( byGetOrPost == 1 ) { // Post method
                String data  = URLEncoder.encode( "username", "UTF-8" ) + "=";
                data += URLEncoder.encode( username,   "UTF-8" ) + "&";
                data += URLEncoder.encode( "password", "UTF-8" ) + "=";
                data += URLEncoder.encode( password,   "UTF-8" );
                OutputStreamWriter wr = new OutputStreamWriter(
                        conn.getOutputStream( ) );
                wr.write( data );
                wr.flush( );
            }

            // Read server response.
            BufferedReader reader = new BufferedReader(
            new InputStreamReader( conn.getInputStream( ) ));
            StringBuilder sb = new StringBuilder( );
            String      line = null;
            while (( line = reader.readLine( ) ) != null ) {
                sb.append( line );
                break;
            }
            return sb.toString( );
        }
    catch( Exception e ) {
            return new String( "Exception: " + e.getMessage( ) );
        }
    }

    @Override
    protected void onPostExecute(String result) {
        this.statusField.setText( "Login Successful" );
        this.roleField.setText  ( result );
    }
}
