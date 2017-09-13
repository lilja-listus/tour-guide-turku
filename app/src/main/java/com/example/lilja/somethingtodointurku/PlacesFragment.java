package com.example.lilja.somethingtodointurku;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lilja on 7/5/17.
 */

public class PlacesFragment extends Fragment {
    //public empty constructor
    public PlacesFragment() {
    }

    /**
     * Building the layout
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return rootView
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_in_a_list, container, false);
        // Create a list of words
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.name_turku_castle, R.string.description_turku_castle, R.drawable.turunlinna));
        items.add(new Item(R.string.name_turku_cathedral, R.string.description_turku_cathedral, R.drawable.tuomiokirkko));
        items.add(new Item(R.string.name_luostarinmaki, R.string.description_luostarinmaki, R.drawable.museo));
        items.add(new Item(R.string.name_turku_university, R.string.description_turku_University, R.drawable.yliopisto));
        items.add(new Item(R.string.name_turku_library, R.string.description_turku_library, R.drawable.kirjasto));
        items.add(new Item(R.string.name_market_hall, R.string.description_market_hall, R.drawable.kauppahalli));
        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}