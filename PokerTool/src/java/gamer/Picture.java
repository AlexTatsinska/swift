package gamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    String pictureLink;

    public Picture(String pictureLink) {
        setPictureLink(pictureLink);
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getPictureLink() {
        return pictureLink;
    }
    
    public String copyFile(String pictureLink){
        InputStream inStream = null;
	OutputStream outStream = null;
        String newPictureLink = null;
            try{

    	   File afile =new File(pictureLink);
           File bfile =new File("test/"+afile.getName());

    	   inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);

    	    byte[] buffer = new byte[1024];

    	    int length;
    	    //copy the file content in bytes
    	    while ((length = inStream.read(buffer)) > 0){

    	    	outStream.write(buffer, 0, length);
newPictureLink = bfile.getAbsolutePath();
    	    }

    	    inStream.close();
    	    outStream.close();
            }catch(IOException e){
    	    e.printStackTrace();
    	}
            return newPictureLink;
    }
    
}
