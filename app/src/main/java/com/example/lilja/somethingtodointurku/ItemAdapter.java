package com.example.lilja.somethingtodointurku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lilja on 7/5/17.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    /**
     * Create a new ItemAdapter object.
     *
     * @param context current context
     * @param items   is the list of items
     */

    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the  item at this position in the list and set the text
        Item currentItem = getItem(position);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //set the translation
        defaultTextView.setText(currentItem.getNameOfThePlace());
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentItem.getDescription());
        //set the image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        return listItemView;
    }
}