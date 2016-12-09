
import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Task2_ListRelativeFileStructure {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "D:\\Swift";
        //String path = sc.nextLine();
        Queue<String> directory = new ArrayDeque<>();
        File file = new File(path);
        File[] listOfFiles = file.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getAbsolutePath().substring(path.length()+1, listOfFiles[i].getAbsolutePath().length()));
            } else if (listOfFiles[i].isDirectory()) {
                directory.add(listOfFiles[i].getAbsolutePath());
            }
        }
        while (!directory.isEmpty()) {
            File subFile = new File(directory.peek());
            File[] listOfSubFiles = subFile.listFiles();
            for (int i = 0; i < listOfSubFiles.length; i++) {
                if (listOfSubFiles[i].isFile()) {                   
                    System.out.println(listOfFiles[i].getAbsolutePath().substring(path.length()+1, listOfFiles[i].getAbsolutePath().length()));
                    directory.poll();
                } else if (listOfSubFiles[i].isDirectory()){   
                    //System.out.println(listOfSubFiles[i].getAbsolutePath());
                    String result = listOfSubFiles[i].getAbsolutePath();
                    
                    directory.add(result);
                    directory.poll();
                  //  System.out.println(directory.peek());
                    
                }
            }
        }
    }
    
}
