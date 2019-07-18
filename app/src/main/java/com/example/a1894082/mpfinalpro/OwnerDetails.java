package com.example.a1894082.mpfinalpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class OwnerDetails extends AppCompatActivity {

    TextView txt_OwnerName, txt_PublicRepo, txt_follower, txt_following;
    ImageView img_Owner;

    String Oname, Oimg, Repo_url;
    String Public_repo, follower, following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_details);


        txt_OwnerName = findViewById(R.id.txt_OwnerName);
        txt_PublicRepo = findViewById(R.id.txt_PublicRepo);
        txt_follower = findViewById(R.id.txt_follower);
        txt_following = findViewById(R.id.txt_Following);
        img_Owner = findViewById(R.id.img_Owner);

        Intent i = getIntent();

        String Url = i.getStringExtra("OwnerUrl");

        System.out.println("Owner URl : " + Url);

        try {

            String OwnerDetails =  new AsyncroData().execute(Url).get();

            System.out.println("This is from Repo Description : " + OwnerDetails);

            JSONObject objOwner = new JSONObject(OwnerDetails);

            Oname = objOwner.getString("login");
            Oimg = objOwner.getString("avatar_url");
            Repo_url = objOwner.getString("repos_url");
            Public_repo = objOwner.getString("public_repos");
            follower = objOwner.getString("followers");
            following = objOwner.getString("following");



        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        txt_OwnerName.setText("Owner Name : " + Oname);
        txt_PublicRepo.setText("Public Repo : " + Public_repo);
        txt_follower.setText("Followers :  " + follower);
        txt_following.setText("Following : " + following);

        Picasso.get().load(Oimg).into(img_Owner);

        txt_PublicRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(OwnerDetails.this,"Test",Toast.LENGTH_LONG).show();

                Intent i = new Intent(OwnerDetails.this,MainActivity.class);
                i.putExtra("OwnerRepo",Repo_url);
                startActivity(i);

            }
        });



    }
}
