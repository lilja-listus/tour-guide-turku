package com.example.lilja.somethingtodointurku;

/**
 * Created by Liliana Listus in 2017 as a study project for a nanodegree at udacity.com
 */

public class Item {

    //Constant value that represents no image was provided for the place
    private static final int NO_IMAGE_PROVIDED = -1;

//location ID of the item
    //name of the place ID
    private int nameOfThePlace;
    private int description;
    // ID of the audio resorce item
    private int audioResourceId;
    //Image resource ID
    private int image = NO_IMAGE_PROVIDED;

    /**
     * Constructors to create items. There are three of them for different input parameters
     */

    public Item(int mNameOfThePlace, int mDescription) {
        nameOfThePlace = mNameOfThePlace;
        description = mDescription;
    }

    //another constructor for with the images
    public Item(int mNameOfThePlace, int mDescription, int mImage) {
        nameOfThePlace = mNameOfThePlace;
        description = mDescription;
        image = mImage;
    }

    //another constructor for with audio
    public Item(int mNameOfThePlace, int mDescription, int mImage, int mAudioResourceId) {
        nameOfThePlace = mNameOfThePlace;
        description = mDescription;
        image = mImage;
        audioResourceId = mAudioResourceId;
    }

    /**
     * get methods for all the parameters
     */
    public int getNameOfThePlace() {
        return nameOfThePlace;
    }

    public int getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    //to check wether there is an image provided

    public boolean hasImage() {
        return image != NO_IMAGE_PROVIDED;
    }
}