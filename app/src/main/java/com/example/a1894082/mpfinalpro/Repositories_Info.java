package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class Repositories_Info extends AppCompatActivity {

    TextView Name,lang,cont,ownerdetails,ownername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_info);


        Name= findViewById(R.id.Name);
        lang= findViewById(R.id.lang);
        cont= findViewById(R.id.cont);
        ownerdetails=findViewById(R.id.ownerdetails);

        //ownerdetails =  findViewById(R.id.ownerdetails);

        Intent i = getIntent();

        Repositories_Git g = i.getParcelableExtra("data");

        String name = g.getName();

        System.out.println(" "+g.getName());

//        Picasso.get().load(p.getPimg()).into(pimg);

        Name.setText(g.getName());
        cont.setText(g.getCont());
        lang.setText(g.getLang());
        ownerdetails.setText(""+g.getOwnerdetails());

        System.out.println("This is from products page: "+name);


        System.out.println("This is from products page: "+cont);

        System.out.println("This is from products page: "+lang);

        System.out.println("This is from products page: "+ownerdetails);


    }
}
