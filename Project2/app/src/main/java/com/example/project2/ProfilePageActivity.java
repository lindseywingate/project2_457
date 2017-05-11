package com.example.project2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfilePageActivity extends Activity {
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Intent intent = getIntent();
        String results = intent.getStringExtra("key");
        if (results.equals("No results")) {
            //do nothing
        } else {
            List<String> list = new ArrayList<String>(Arrays.asList(results.split("-")));
            count = list.size() / 3;
            //puthere.setText(list.get(0));

            LinearLayout linear = (LinearLayout) findViewById(R.id.horizontal_ll);

            int isbn = 1;
            int title = 0;
            int price = 2;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            for (int i = 0; i < count; i++) {
                TextView stuff = new TextView(this);
                stuff.setText("Title: " + list.get(title) + ", ISBN: " + list.get(isbn) + ", Price: " + list.get(price));
                stuff.setId(i);
                stuff.setLayoutParams(params);
                linear.addView(stuff);
                isbn = isbn + 3;
                title = title + 3;
                price = price + 3;
            }
        }
    }

    public void addtocart(View v) {
        //CheckBox thisguy = (CheckBox) findViewById(0);
        //String thisstuff = thisguy.getText().toString();

        /*String Books = "";
        for(int i=0; i<count; i++) {
            CheckBox thisguy = (CheckBox) findViewById(i);
            if(thisguy.isChecked()) {
                Books = Books + thisguy.getText().toString()+", ";
            }
        }*/
        Intent intent_name = new Intent();
        intent_name.setClass(this, CheckOutActivity.class);
        //intent_name.putExtra("somethingnew", thisstuff);
        this.startActivity(intent_name);
    }

    public void test(View v) {

    }

}
