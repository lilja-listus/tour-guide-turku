package com.example.lilja.somethingtodointurku;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lilja on 7/5/17.
 */

public class PhrasesFragment extends Fragment {

    // mediaplayer for playing audio
    private MediaPlayer mMediaPlayer;

    // to handle the audiofocus
    private AudioManager mAudioManager;

    //creating new AudioManager
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        /**
         * to handle audiofocus changes
         *
         * @param focusChange
         */
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    /**
     * The listener that is triggered when mediaplayer has completed paying audio
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    // Required empty public constructor
    public PhrasesFragment() {
    }

    /**
     * bulding the layout
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_in_a_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        /**
         * Create a list of words. This one contains the phrase, translation, picture to show
         * it is audio and audio file
         */
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.moi, R.string.hello, R.drawable.ic_audiotrack_black_24dp, R.raw.moi));
        items.add(new Item(R.string.mita_kuuluu, R.string.how_are_you, R.drawable.ic_audiotrack_black_24dp, R.raw.mita_kuuluu));
        items.add(new Item(R.string.missa_on_vessa, R.string.where_is_toilet, R.drawable.ic_audiotrack_black_24dp, R.raw.missa_on_vessa));
        items.add(new Item(R.string.yksi_kahvi, R.string.one_coffee, R.drawable.ic_audiotrack_black_24dp, R.raw.yksi_kahvi));
        items.add(new Item(R.string.kiitos, R.string.thank_you, R.drawable.ic_audiotrack_black_24dp, R.raw.kiitos));
        items.add(new Item(R.string.minun_nimi, R.string.my_name, R.drawable.ic_audiotrack_black_24dp, R.raw.minun_nimi));
        items.add(new Item(R.string.kaunis_kaupunki, R.string.beautiful_city, R.drawable.ic_audiotrack_black_24dp, R.raw.turku_on_kaunis));

        // new adapter
        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Item item = items.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), item.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }


        });
        return rootView;
    }
    /**
     * what mediaPlayer does when onStop is called
     */
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}

