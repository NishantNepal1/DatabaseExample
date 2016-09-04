package com.hfad.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_example);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.acField);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[]{"Nepal", "India", "China"});
        autoCompleteTextView.setAdapter(arrayAdapter);


    }
}
