package com.example.android.zailet;

/**
 * Created by Karan on 08-06-2017.
 */

public class Blogs {
    private String mTitle;
    private String mTime;
    private String mDescription;
    private String mThumbnail;
    private String mAuthorName;
    private String mDP;

    public Blogs(String postTitle, String time, String description, String thumbnail, String authorName, String dp)
    {
        mTitle = postTitle;
        mTime = time;
        mDescription = description;
        mThumbnail = thumbnail;
        mAuthorName = authorName;
        mDP = dp;
    }

    public  String getTitle() {
        return mTitle;
    }
    public  String  getTime() {
        return mTime;
    }
    public  String getDescription() {
        return mDescription;
    }
    public String getThumbnail() { return mThumbnail; }
    public String getAuthorName() { return mAuthorName; }
    public String getDP() { return mDP; }
}
