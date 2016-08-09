package com.mauiie.open;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.testCrash).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String testStr = null;
        int length = testStr.length();
    }
}
