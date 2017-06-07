package com.example.android.zailet;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.attr.resource;
import static com.example.android.zailet.R.id.grid;

/**
 * Created by Karan on 06-06-2017.
 */

public class TopicsAdapter extends ArrayAdapter<Topics> {

    public TopicsAdapter(Context context, List<Topics> topics) {
        super(context, 0, topics);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.topics_item, parent, false);
        }

        Topics currentTopic = getItem(position);

        TextView interestTextView = (TextView) gridItemView.findViewById(R.id.grid_text);
        interestTextView.setText(currentTopic.getInterest());

        String imageUrl = currentTopic.getUrl();
        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.grid_image);
        Picasso.with(getContext()).load(imageUrl).resize(100, 100).into(imageView);

        return gridItemView;
    }

}
