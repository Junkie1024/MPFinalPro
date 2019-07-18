package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView pltlst;

    CustomListAdapter adapt;
    ArrayList<Repositories> pro;

    String Oname = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        pltlst = findViewById(R.id.reposlist);

        String ls = getResources().getString(R.string.link);

        pro =  new ArrayList<>();

        if(getIntent().getStringExtra("OwnerRepo")!=null){
            Oname = getIntent().getStringExtra("OwnerName");
        }
        if(Oname != ""){

        }
        else {
            try {
                String mysts =  new AsyncroData().execute(ls).get();

                System.out.println("This is from MainActivity:"+mysts);
                mysts = "{\"Name\":" +mysts+"}";
                JSONObject mainobj =  new JSONObject(mysts);

                JSONArray proarray = mainobj.getJSONArray("Name");

/*
            JSONObject object = (JSONObject) new JSONTokener(ls).nextValue();
            String query = object.getString("query");
            JSONArray locations = object.getJSONArray("login");
            System.out.println("Owner login name:"+locations);*/

                for (int i=0;i<proarray.length();i++ )
                {
                    JSONObject childobj = proarray.getJSONObject(i);



                    String pname = childobj.getString("name");
                    String Full_name = childobj.getString("full_name");
                    String plink = (String) childobj.getString("owner");





                    JSONObject jObject = new JSONObject(plink);

                    String oname = jObject.getString("login");

                    String url = jObject.getString("url");

                    String langurl = childobj.getString("languages_url");






                    System.out.println(oname);

                    pro.add(new Repositories(pname,Full_name,oname,langurl,url));

                    System.out.println("names : "+childobj.getString("name"));
                }



                System.out.println("ArrayList size: "+pro.size());


                adapt =  new CustomListAdapter(MainActivity.this,pro);

                pltlst.setAdapter(adapt);

                pltlst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(MainActivity.this,pro.get(position).getPname(),Toast.LENGTH_LONG).show();

                        Intent i = new Intent(MainActivity.this,Repo_description.class);
                        i.putExtra("data",pro.get(position));
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
}
