package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Repo_description extends AppCompatActivity {


    TextView rname,fullrname,lurl,oname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_description);

        rname = findViewById(R.id.rname);

        fullrname = findViewById(R.id.fullrname);
        oname = findViewById(R.id.oname);
        lurl = findViewById(R.id.lurl);

        Intent i = getIntent();

        Repositories p = i.getParcelableExtra("data");

        String name = p.getPname();

        rname.setText(p.getPname());

        lurl.setText(p.getLangurl());

        oname.setText(name);

        oname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Repo_description.this,MainActivity.class);
                i.putExtra("OwnerName",oname.getText().toString());
                startActivity(i);

            }
        });

    }
}
