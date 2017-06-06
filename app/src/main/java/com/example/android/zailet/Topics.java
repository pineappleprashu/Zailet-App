package com.example.android.zailet;

/**
 * Created by Karan on 06-06-2017.
 */

public class Topics {
    private int mID;
    private String mInterest;
    private String mUrl;

    public Topics(int id, String interest, String url)
    {
        mID = id;
        mInterest = interest;
        mUrl = url;
    }

    public  int getID() {
        return mID;
    }
    public  String  getInterest() {
        return mInterest;
    }
    public  String getUrl() {
        return mUrl;
    }
}
