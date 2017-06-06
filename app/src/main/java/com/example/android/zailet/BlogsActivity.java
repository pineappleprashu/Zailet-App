package com.example.android.zailet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Karan on 06-06-2017.
 */

public class BlogsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        setTitle(getString(R.string.blogs_activity_title));
    }
}
