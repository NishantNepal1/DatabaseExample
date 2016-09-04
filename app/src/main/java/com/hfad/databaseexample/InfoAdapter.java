package com.hfad.databaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 9/1/2016.
 */
public class InfoAdapter extends ArrayAdapter<Info> {
    ArrayList<Info> lvList;
    Context context;

    public InfoAdapter(Context context, int resource, ArrayList<Info> list) {
        super(context, resource, list);
        this.lvList = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return lvList.size();
    }

    @Override
    public Info getItem(int position) {
        return lvList.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listdata, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.txtName);
        TextView adress = (TextView) convertView.findViewById(R.id.txtAdress);
        TextView contact = (TextView) convertView.findViewById(R.id.txtContactId);
        TextView gender = (TextView) convertView.findViewById(R.id.txtGender);


        Info lvList = getItem(position);
        name.setText(lvList.getName());
        adress.setText(lvList.getAdress());
        contact.setText(lvList.getContact());
        gender.setText(lvList.getGetGender());


        return convertView;
    }

    public void notifyData(ArrayList<Info> list) {
        this.lvList = list;
        notifyDataSetChanged();
    }


}
