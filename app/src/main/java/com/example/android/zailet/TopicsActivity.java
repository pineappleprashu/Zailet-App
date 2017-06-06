package com.example.android.zailet;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


import static android.media.CamcorderProfile.get;

/**
 * Created by Karan on 06-06-2017.
 */

public class TopicsActivity extends AppCompatActivity
        implements LoaderCallbacks<List<Topics>>{

    private static final String LOG_TAG = TopicsActivity.class.getName();

    private TopicsAdapter mAdapter;
    private TextView mEmptyStateTextView;

    private static final String TOPIC_REQUEST_URL =
            "http://zailet.com/zailet_internship_assignment/get_data.php?get_topics=1";

    private static final int TOPIC_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        setTitle(getString(R.string.topics_activity_title));

        GridView topicsGridView = (GridView) findViewById(R.id.grid);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        topicsGridView.setEmptyView(mEmptyStateTextView);

        mAdapter = new TopicsAdapter(this, new ArrayList<Topics>());
        topicsGridView.setAdapter(mAdapter);

        topicsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();

                        loaderManager.initLoader(TOPIC_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<Topics>> onCreateLoader(int i, Bundle bundle) {
        return new TopicsLoader(this, TOPIC_REQUEST_URL);
    }
    @Override
    public void onLoadFinished(Loader<List<Topics>> loader, List<Topics> topics) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_topics);

        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (topics != null && !topics.isEmpty()) {
            mAdapter.addAll(topics);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Topics>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
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