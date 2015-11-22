package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.codepath.jokesandroidlib.JokesDisplayActivity;

public class JokesAppActivity extends AppCompatActivity implements EndpointsAsyncTask.OnCompletionListener {
    private ProgressBar progressBar;

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        beginJoke();
    }

    @SuppressWarnings("unchecked")
    private void beginJoke() {
        progressBar.setVisibility(View.GONE);
        new EndpointsAsyncTask(this).execute();
        //STEP 1
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(String result) {
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, JokesDisplayActivity.class);
        intent.putExtra(JokesDisplayActivity.JOKE_TEXT, result);
        startActivity(intent);
    }
}