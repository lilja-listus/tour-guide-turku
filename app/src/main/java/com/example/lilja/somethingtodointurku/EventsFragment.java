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

public class EventsFragment extends Fragment {

    //public empty constructor
    public EventsFragment() {
    }

    /**
     * Building the layout of the fragment
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

        // Create a list of events taking place in the city
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.name_ruisrock, R.string.description_ruisrock));
        items.add(new Item(R.string.name_tallship_races, R.string.description_tallship_races));
        items.add(new Item(R.string.name_europeade, R.string.description_europeade));
        items.add(new Item(R.string.name_tournament, R.string.description_tournament));

        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
