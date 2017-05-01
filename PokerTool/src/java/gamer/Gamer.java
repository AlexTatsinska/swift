package gamer;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Gamer {
    int gamerId;
    String gamerName;
    List<String> gamerNote;
    List<Picture> gamerPictures;

    public Gamer(int gamerId, String gamerName, List<String> gamerNote) {
        setGamerName(gamerName);
        setGamerNote(gamerNote);
    }

    public Gamer(int gamerId, String gamerName, List<String> gamerNote, List<Picture> gamerPictures) {
        setGamerName(gamerName);
        setGamerNote(gamerNote);
        setGamerPictures(gamerPictures);
    }

    public Gamer(int gamerId, String gamerName) {
        setGamerId(gamerId);
        setGamerName(gamerName);
    }

    public void setGamerId(int gamerId) {
        this.gamerId = gamerId;
    }
    
    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public void setGamerNote(List<String> gamerNote) {
        this.gamerNote = gamerNote;
    }

    public void setGamerPictures(List<Picture> gamerPictures) {
        this.gamerPictures = gamerPictures;
    }

    public int getGamerId() {
        return gamerId;
    }
    
    public String getGamerName() {
        return gamerName;
    }

    public List<String> getGamerNote() {
        return gamerNote;
    }

    public List<Picture> getGamerPictures() {
        return gamerPictures;
    }
    
    public void addGamerPicture(Picture picture){
        gamerPictures.add(picture);
    }
    
}
