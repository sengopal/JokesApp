package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.jokes.application.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by sengopal on 11/22/15.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private OnCompletionListener onCompletionListener;

    public interface OnCompletionListener{
        void onComplete(String result);
    }

    public EndpointsAsyncTask(OnCompletionListener onCompletionListener){
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onCompletionListener.onComplete(s);
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            //
            //MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
            //new AndroidJsonFactory(), null)
            //// options for running against local devappserver
            //// - 10.0.2.2 is localhost's IP address in Android emulator
            //// - turn off compression when running against local devappserver
            //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
            //.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            //@Override
            //public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
            //abstractGoogleClientRequest.setDisableGZipContent(true);
            //}
            //});
            //
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokescloud.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
