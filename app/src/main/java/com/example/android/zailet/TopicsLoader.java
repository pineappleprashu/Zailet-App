package com.example.android.zailet;

/**
 * Created by Karan on 06-06-2017.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class TopicsLoader extends AsyncTaskLoader<List<Topics>> {

    /** Tag for log messages */
    private static final String LOG_TAG = TopicsLoader.class.getName();

    /** Query URL */
    private String mUrl;


    public TopicsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Topics> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Topics> earthquakes = QueryUtils.fetchTopicData(mUrl);
        return earthquakes;
    }
}
