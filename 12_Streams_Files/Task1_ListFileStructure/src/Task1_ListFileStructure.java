
import java.io.File;
import java.util.ArrayList;
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
public class Task1_ListFileStructure {
    public static void main(String[] args){
       String path = "D:\\Swift";
       // List<String> file = new ArrayList<>();
       File file = new File(path);
       File[] listOfFiles = file.listFiles();
       for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println(listOfFiles[i].getAbsolutePath());
      } else if (listOfFiles[i].isDirectory()) {  
       System.out.println(listOfFiles[i].getAbsolutePath());
      }
    }
      
    
       }
}
