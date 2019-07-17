package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView pltlst;
    ListAdapter plt;
    ArrayList<Repositories_Git> pnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pltlst = findViewById(R.id.plants_list);

        String ls = getResources().getString(R.string.link);

        pnt = new ArrayList<>();

        try {
            String mysts = new AsyncroData().execute(ls).get();

            System.out.println("This is from MainActivity:" + mysts);

            mysts = "{\"Name\":" +mysts+"}";

            JSONObject mainobj = new JSONObject(mysts);

            JSONArray proarray = mainobj.getJSONArray("Name");

            for (int i = 0; i < proarray.length(); i++) {
                JSONObject childobj = proarray.getJSONObject(i);

                String name = childobj.getString("name");

                String link  = childobj.getString("full_name");


                pnt.add(new Repositories_Git(name,link));


            }

            System.out.println("ArrayList size: " + pnt.size());


            plt = new ListAdapter(MainActivity.this, pnt);

            pltlst.setAdapter(plt);


            pltlst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(MainActivity.this, pnt.get(position).getname(), Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("data", pnt.get(position));





                    Intent i = new Intent(MainActivity.this, Repo_Descrip.class);
                    i.putExtra("data", pnt.get(position));
                    startActivity(i);
                }
            });


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
