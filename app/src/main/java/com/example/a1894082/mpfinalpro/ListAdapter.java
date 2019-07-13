package com.example.a1894082.mpfinalpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class ListAdapter extends BaseAdapter {
    Context c;
    ArrayList<Plants> plnt;

    LayoutInflater inflater;

    public ListAdapter(Context c, ArrayList<Plants> pro) {
        this.c = c;
        this.plnt = plnt;
    }

    public Context getC() {
        return c;
    }

    public ArrayList<Plants> getPro() {
        return plnt;
    }

    @Override
    public int getCount() {
        return plnt.size();
    }

    @Override
    public Object getItem(int position) {
        return plnt.get(position);
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
            convertView = inflater.inflate(R.layout.list_plants,parent,false);
        }

        //ImageView pimg = convertView.findViewById(R.id.descrip_img);
        TextView Name  = convertView.findViewById(R.id.plnt_name);

        //Picasso.get().load(plnt.get(position).getPimg()).into(pimg);
        Name.setText(plnt.get(position).getName());


        return convertView;
    }
}
