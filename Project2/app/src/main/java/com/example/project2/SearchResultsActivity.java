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

public class SearchResultsActivity extends Activity {
public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);

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

    public void addtocart() {
        List Books = new ArrayList();
        for(int i=0; i<count; i++) {
            CheckBox thisguy;
            thisguy = (CheckBox) findViewById(i);
            if(thisguy.isChecked()) {
                Books.add(thisguy.getText().toString());
            }
        }
        new ShoppingCartActivity(this).execute(Books);
    }


}
