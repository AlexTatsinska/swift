package gamer;

import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Picture {
    Image pictureLink;
    String pictureName;

//    public Picture(Image pictureLink, String PictureName) {
//        setPictureLink(pictureLink);
//        setPictureName(pictureName);
//    }

    public Picture(Image pictureLink, String pictureName) {
        this.pictureLink = pictureLink;
        this.pictureName = pictureName;
    }
    

    public void setPictureLink(Image pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Image getPictureLink() {
        return pictureLink;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    
    
    
}
