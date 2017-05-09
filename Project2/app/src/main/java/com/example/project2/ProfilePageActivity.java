package com.example.project2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfilePageActivity extends Activity {
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_page);

        Intent intent = getIntent();
        String results = intent.getStringExtra("key");

        List<String> list = new ArrayList<String>(Arrays.asList(results.split("-")));
        count = list.size()/3;
        //puthere.setText(list.get(0));

        LinearLayout linear = (LinearLayout) findViewById(R.id.horizontal_ll);

        int isbn = 1;
        int title = 0;
        int price = 2;
        int quantity = 3;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        TextView pagetitle = new TextView(this);
        pagetitle.setText("Welcome Customer!");
        pagetitle.setLayoutParams(params);
        linear.addView(pagetitle);

        for(int i = 0; i<count; i++) {
            TextView stuff = new TextView(this);
            stuff.setText("Title: "+list.get(title)+", Quantity: "+list.get(quantity)+", ISBN: "+list.get(isbn)+", Price: "+list.get(price));
            stuff.setId(i);
            stuff.setLayoutParams(params);
            linear.addView(stuff);
            isbn = isbn + 4;
            title = title + 4;
            price = price + 4;
            quantity = quantity + 4;
        }

    }


}
