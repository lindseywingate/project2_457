package com.example.project2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
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

public class ProfilePageActivity extends AppCompatActivity {
    int count;
    private Context context;
    int isbn = 3;
    int title = 0;
    int price = 2;
    int quantity = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = context;
        setContentView(R.layout.activity_profile_page);

        Intent intent = getIntent();
        String results = intent.getStringExtra("key");

        final List<String> list = new ArrayList<String>(Arrays.asList(results.split("-")));
        count = list.size() / 3;
        //puthere.setText(list.get(0));

        LinearLayout linear = (LinearLayout) findViewById(R.id.horizontal_ll);



        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        TextView pagetitle = new TextView(this);
        pagetitle.setText("Welcome Customer!");
        pagetitle.setLayoutParams(params);
        linear.addView(pagetitle);

        for (int i = 0; i < count; i++) {
            TextView stuff = new TextView(this);
            TextView stuff2 = new TextView(this);
            TextView stuff3 = new TextView(this);
            TextView stuff4 = new TextView(this);

            stuff.setText("Title: " + list.get(title));
            stuff2.setText("Quantity: " + list.get(quantity));
            stuff3.setText("ISBN: " + list.get(isbn));
            stuff4.setText("Price: " + list.get(price));
            stuff.setId(i);
            stuff.setLayoutParams(params);
            stuff2.setLayoutParams(params);
            stuff3.setLayoutParams(params);
            stuff4.setLayoutParams(params);
            linear.addView(stuff);
            linear.addView(stuff2);
            linear.addView(stuff3);
            linear.addView(stuff4);

            final String title_ = list.get(title);

            ProfilePageActivity.makeTextViewHyperlink(stuff);
            stuff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfilePageActivity.this, BookActivity.class);
                    intent.putExtra("title", title_);
                    startActivity(intent);
                }
            });

            isbn = isbn + 4;
            title = title + 4;
            price = price + 4;
            quantity = quantity + 4;
        }
    }
    public static void makeTextViewHyperlink(TextView tv) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(tv.getText());
        try {
            ssb.setSpan(new URLSpan("#"), 0, ssb.length(),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(ssb, TextView.BufferType.SPANNABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
