package com.example.android.zailet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import static android.media.CamcorderProfile.get;

/**
 * Created by Karan on 06-06-2017.
 */

public class TopicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        setTitle(getString(R.string.topics_activity_title));
    }

    private void proceed (){
        Intent intent = new Intent(TopicsActivity.this, BlogsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_topics.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_topics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                proceed();
                // Exit activity
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}