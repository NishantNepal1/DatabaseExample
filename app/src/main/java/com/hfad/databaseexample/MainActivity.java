package com.hfad.databaseexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    EditText name;
    EditText address;
    EditText contact;
    EditText gender;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnSave = (Button) findViewById(R.id.submit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.getDbDatabaseManager().addContact(createDataFromForm());
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }

    private Info createDataFromForm() {
        Info info = new Info();
        info.setAdress(address.getText().toString());
        info.setContact(contact.getText().toString());
        info.setGetGender(gender.getText().toString());
        info.setName(name.getText().toString());

        return info;

    }


    public static void start(Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

    public void init() {
        name = (EditText) findViewById(R.id.etName);
        address = (EditText) findViewById(R.id.etAdress);
        contact = (EditText) findViewById(R.id.contactId);
        gender = (EditText) findViewById(R.id.etGender);
    }
}
