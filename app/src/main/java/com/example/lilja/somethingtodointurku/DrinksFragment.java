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

public class DrinksFragment extends Fragment {


    //the empty public constructor
    public DrinksFragment() {
    }

    /**
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
        items.add(new Item(R.string.name_fazer, R.string.description_fazer));
        items.add(new Item(R.string.name_cafe_art, R.string.description_cafe_art));
        items.add(new Item(R.string.name_tiirikkala, R.string.description_tiirikkala));
        items.add(new Item(R.string.name_koulu, R.string.description_koulu));
        items.add(new Item(R.string.name_apteekki, R.string.description_apteekki));

        //new adapter of items
        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}