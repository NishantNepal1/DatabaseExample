package com.hfad.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactInfo extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView lvList;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewerr);
        init();
        ArrayList<Info> infos=myApplication.getDbDatabaseManager().fetchContact();
        infoAdapter = new InfoAdapter(this, R.layout.listviewerr, infos);
        lvList.setAdapter(infoAdapter);

        lvList.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuAdd) {
            // MainActivity.start(ContactInfo.this);
            Intent intent = new Intent(ContactInfo.this, MainActivity.class);
            startActivityForResult(intent, 101);
        }
        return super.onOptionsItemSelected(item);
    }

    public void init() {
        lvList = (ListView) findViewById(R.id.listView);



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Toast.makeText(ContactInfo.this, "Hello", Toast.LENGTH_SHORT).show();
        Info info= (Info) parent.getAdapter().getItem(position);
        
        /*
        myApplication.getDbDatabaseManager().deleteContact(info.getContact());
        infoAdapter.remove(info);
        infoAdapter.notifyDataSetChanged();*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RESULT_OK == resultCode && requestCode == 101) {
            ArrayList<Info> list = myApplication.getDbDatabaseManager().fetchContact();
            infoAdapter.notifyData(list);

        }
    }

}
