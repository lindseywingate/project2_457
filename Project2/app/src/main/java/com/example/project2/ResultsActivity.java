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

public class ResultsActivity extends Activity {
int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        String results = intent.getStringExtra("key");
        TextView puthere = (TextView) findViewById(R.id.textView);
        puthere.setText(results);

        count = 2;
        LinearLayout linear = (LinearLayout) findViewById(R.id.vertical_ll);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        for(int i = 0; i<count; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setId(count);
            checkBox.setText("This");
            
            checkBox.setLayoutParams(params);
            linear.addView(checkBox);
        }

    }


}
