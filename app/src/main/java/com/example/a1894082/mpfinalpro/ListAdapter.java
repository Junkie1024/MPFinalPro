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
    ArrayList<Repositories_Git> reposit;

    LayoutInflater inflater;

    public ListAdapter(Context c, ArrayList<Repositories_Git> pro) {
        this.c = c;
        this.reposit = reposit;
    }

    public Context getC() {
        return c;
    }

    public ArrayList<Repositories_Git> getPro() {
        return reposit;
    }

    @Override
    public int getCount() {
        return reposit.size();
    }

    @Override
    public Object getItem(int position) {
        return reposit.get(position);
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
            convertView = inflater.inflate(R.layout.repo_list,parent,false);
        }

        //ImageView pimg = convertView.findViewById(R.id.descrip_img);
        TextView Name  = convertView.findViewById(R.id.reposit_name);

        //Picasso.get().load(reposit.get(position).getPimg()).into(pimg);
        Name.setText(reposit.get(position).getName());


        return convertView;
    }
}
