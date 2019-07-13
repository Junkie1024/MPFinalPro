package com.example.a1894082.mpfinalpro;

import android.os.AsyncTask;

public class AsyncroData extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings)
    {
        String jsonlink =  strings[0];
        HTTPHandler show = new HTTPHandler();
        String json =  show.makeServiceCall(jsonlink);
        System.out.println("This is JSON: "+ json);
        return json;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
