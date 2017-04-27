package com.example.aplicacaodelivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileResultsActivity extends AppCompatActivity {

    Bundle b=this.getIntent().getExtras();
    String[] array = b.getStringArray(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_results);
    }

}
