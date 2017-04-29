package com.example.aplicacaodelivros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.aplicacaodelivros.R.id.editText;
import static com.example.aplicacaodelivros.R.id.icon;

public class SearchResultsActivity extends Activity {

    @Override
    //identify fields where you are pulling in info from user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }


}
