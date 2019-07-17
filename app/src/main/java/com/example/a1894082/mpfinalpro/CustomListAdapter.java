package com.example.a1894082.mpfinalpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter  extends BaseAdapter {

    Context c;
    ArrayList<Repositories> pro;

    LayoutInflater inflater;

    public CustomListAdapter(Context c, ArrayList<Repositories> pro) {
        this.c = c;
        this.pro = pro;
    }

    public Context getC() {
        return c;
    }

    public ArrayList<Repositories> getPro() {
        return pro;
    }

    @Override
    public int getCount() {
        return pro.size();
    }

    @Override
    public Object getItem(int position) {
        return pro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView  ==  null)
        {
            convertView = inflater.inflate(R.layout.repo_list_items,parent,false);
        }


        TextView pname  = convertView.findViewById(R.id.textView);

         //Picasso.get().load(pro.get(position).getPimg()).into(pimg);
        pname.setText(pro.get(position).getPname());


        return convertView;

    }
}