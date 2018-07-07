package com.alesterlewis.generallibraryapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Alester Lewis on 5/10/2018.
 */

public class AsyncExample extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task);
    }

    /*
    * The three generics that go in between '<>'
    * are Params, Progress, and Result
    * in this case we will use string for now...
     */
    private class GeneralAsync extends AsyncTask<String, String, String>{

        private final String TAG = "GeneralAsync";
        /*
        * These four methods must always be called when using AsyncTask
        * These methods are placed in the order that they are called
        */


        /*
        This is where alot of the magic happens
        Note that the parameter type here is the same as the Params type
        so if Params is string the doInBackground function will take a variable number of
        Strings.
        */

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            //publishProgress(/*publish something cute here*/);

            //Here we will leverage Okttp3 to make our get request
            OkHttpClient client = new OkHttpClient();

            //Here we build the query string
                Request request = new Request.Builder()
                        .url(strings[0])
                        .build();
                String responseString = "";
                try{

                Response response = client.newCall(request).execute();
                // we may want to do some error checking here to make sure the request was received
                responseString = response.body().string();

            }
            catch (Exception e){
                Log.d(TAG, "doInBackground: we have a problem - "+e);
            }

            return responseString;
        }

        /*
        * this functions arguments will be the same as the progress generic
        * */
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        /*
        * This functions arguments will be the same as Result generic
        * here we can do some JSON or XML parsing
        * for this general example we'll do some JSON Parsing
        * */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try{

                JSONObject jsonObject = new JSONObject(s);

            }catch(Exception e){

            }

        }


    }
}
