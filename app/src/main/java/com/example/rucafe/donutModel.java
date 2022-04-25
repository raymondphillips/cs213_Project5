package com.example.rucafe;

/**
 * the donut model for the recycler view.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class donutModel {
    int image;
    String header, desc;

    /**
     * a method to get the image
     * @return the image
     */
    public int getImage() {
        return image;
    }

    /**
     * a method to set the Image to the current iamge
     * @param image takes in an image
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * a method to get the header
     * @return
     */
    public String getHeader() {
        return header;
    }

    /**
     * a method to set the header
     * @param header takes in string header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * a method to get the desc
     * @return desc, the string description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * a method to set the description
     * @param desc takes in a string desc.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * donutModel constructor
     * @param image an image int
     * @param header a string header
     * @param desc a string description
     */
    public donutModel(int image, String header, String desc) {
        this.image = image;
        this.header = header;
        this.desc = desc;
    }
}
