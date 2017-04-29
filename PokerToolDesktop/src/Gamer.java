
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
    String gamerName;
    String gamerNote;
    List<Picture> gamerPictures;

    public Gamer(String gamerName, String gamerNote) {
        this.gamerName = gamerName;
        this.gamerNote = gamerNote;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public void setGamerNote(String gamerNote) {
        this.gamerNote = gamerNote;
    }

    public void setGamerPictures(List<Picture> gamerPictures) {
        this.gamerPictures = gamerPictures;
    }

    public String getGamerName() {
        return gamerName;
    }

    public String getGamerNote() {
        return gamerNote;
    }

    public List<Picture> getGamerPictures() {
        return gamerPictures;
    }
    
    public void addGamerPicture(Picture picture){
        gamerPictures.add(picture);
    }
    
}
