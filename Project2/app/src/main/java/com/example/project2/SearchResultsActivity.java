package com.example.project2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResultsActivity extends Activity {
public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        String results = intent.getStringExtra("key");

        List<String> list = new ArrayList<String>(Arrays.asList(results.split("-")));
        count = list.size()/3;
        //puthere.setText(list.get(0));

        LinearLayout linear = (LinearLayout) findViewById(R.id.horizontal_ll);

        int isbn = 1;
        int title = 0;
        int price = 2;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        for(int i = 0; i<count; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Title: "+list.get(isbn)+", ISBN: "+list.get(title)+", Price: "+list.get(price));
            checkBox.setId(i);
            checkBox.setLayoutParams(params);
            linear.addView(checkBox);
            isbn = isbn + 3;
            title = title + 3;
            price = price + 3;
        }
    }

    public void addtocart(View v) {
        CheckBox thisguy = (CheckBox) findViewById(0);
        String thisstuff = thisguy.getText().toString();

        /*String Books = "";
        for(int i=0; i<count; i++) {
            CheckBox thisguy = (CheckBox) findViewById(i);
            if(thisguy.isChecked()) {
                Books = Books + thisguy.getText().toString()+", ";
            }
        }*/
        Intent intent_name = new Intent();
        intent_name.setClass(this, CheckOutActivity.class);
        intent_name.putExtra("somethingnew", thisstuff);
        this.startActivity(intent_name);
    }

    public void test(View v) {

    }

}
