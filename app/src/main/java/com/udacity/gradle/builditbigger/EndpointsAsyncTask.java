package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.example.rakeshkalyankar.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.reku.jokeput.JokeLibActivity;

import java.io.IOException;

/**
 * Created by rakeshkalyankar on 15/05/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    public EndpointsAsyncTask(){

    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        Log.i("EndpointsAsynctask", "do in Background called");
        if(myApiService == null){ //do this only once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    .setRootUrl("http://192.168.2.12:8080/_ah/api")
                    // - turn off compression when running against local devappserver
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
//            return myApiService.sayHi(name).execute().getData();
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        if (context instanceof MainActivity) {
            Intent intent = new Intent(context, JokeLibActivity.class);
            intent.putExtra(JokeLibActivity.JOKE_INTENT_KEY, result);
            context.startActivity(intent);
        }
    }
}
