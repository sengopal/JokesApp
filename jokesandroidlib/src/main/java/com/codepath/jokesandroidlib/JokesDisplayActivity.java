package com.codepath.jokesandroidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesDisplayActivity extends AppCompatActivity {
    public static final String JOKE_TEXT = "jokeText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String joke = getIntent().getStringExtra(JOKE_TEXT);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(joke);
    }
}