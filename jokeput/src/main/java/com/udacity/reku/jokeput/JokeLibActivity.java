package com.udacity.reku.jokeput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeLibActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_KEY = "joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_lib);

        Intent intent = getIntent();

        TextView textView = (TextView) findViewById(R.id.textView);
        assert textView != null;
        textView.setText(intent.getStringExtra(JOKE_INTENT_KEY));
    }
}
