package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Repositories_List extends AppCompatActivity {

    ListView lsp;
    ListAdapter adapt;
    ArrayList<Repositories_Git> pro;
    String ownername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_list);

            lsp = findViewById(R.id.reposlist);

        String ls = "https://api.github.com/repositories";

//            String ls = getResources().getString(R.string.link);

            pro =  new ArrayList<>();

            try {
                String mysts =  new AsyncroData().execute(ls).get();


                String jobj =  new AsyncroData().execute(ls).get();

                System.out.println("This is from MainActivity:"+mysts);




                JSONArray proarray = new JSONArray(mysts);

                //JSONObject ownerobj = new JSONObject("");

                System.out.println("This is from MainActivity:"+jobj);



/*
                String json = "https://api.github.com/repositories";



                JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
                String query = object.getString("query");
                JSONArray locations = object.getJSONArray("login");



                System.out.println("Owner login name:"+locations);


*/

                for (int i=0;i<proarray.length();i++ )
                {
                    JSONObject childobj = proarray.getJSONObject(i);

                 //   ownername = ownerobj.getString("login");
                    String name = childobj.getString("name");
                    String lang = childobj.getString("languages_url");
                    String ownerdetails = childobj.getString("owner");
                    String cont = childobj.getString("contributors_url");


                  /*  JSONObject ownerobj = new JSONObject();
                    for(int j=0;j<ownerobj.length();j++) {

                        String ownobj = ownerobj.getString("owner");

                        System.out.println("Owner Name:"+ ownerobj.getJSONArray("owner"));
                    }

*/

                    pro.add(new Repositories_Git(name,lang,ownerdetails,cont));

                    System.out.println("names : "+name);
                    System.out.println("lang : "+lang);
                    System.out.println("Owner : "+ownerdetails);
                    System.out.println("cont : "+cont);


                }



               // System.out.println("Owner login name:"+ownername);

                //System.out.println("Name: "+pro);


                adapt =  new ListAdapter(Repositories_List.this,pro);
                lsp.setAdapter(adapt);

                lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(Repositories_List.this,pro.get(position).getName(),Toast.LENGTH_LONG).show();

                        Bundle bundle =  new Bundle();
                        bundle.putParcelable("data",pro.get(position));


                        Intent i = new Intent(Repositories_List.this,Repositories_Info.class);
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

