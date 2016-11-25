
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
public class Task2_FileStructure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        FileSystemObject[] directory = new FileSystemObject[50];
        int counter =1;
        while (!input.equals("END")){           
            String[] split = input.split(" ");
            String command = split[0];
            String path = split[1];
            
            if (command.equals("mkdir")) {
                try {
                   if(checkName(path)==true){
                        createDirectory(path,directory);
                   } else {
                        throw (new IllegalArgumentException("Invalid name specified"));
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(counter+" "+ex);
                }
            }
            input = sc.nextLine();
            counter++;
        } 
    }

    static boolean checkName(String name) throws IllegalArgumentException {
         boolean result = false;
        String check = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz";
        char[] nameArr = name.toCharArray();
        if (name.length() > 0 && name != null) {
            for (int i = 0; i < nameArr.length; i++) {
                if (i > 0) {
                    check = check + "()_!.&";
                    String checkName = "" + nameArr[i];
                    result = check.contains(checkName);
                    if (result == false) {
                        throw (new IllegalArgumentException("Invalid name specified"));                        
                    }
                } else if (i == 0) {
                    String checkName = "" + nameArr[i];
                    result = check.contains(checkName);
                    if (result == false) {
                        throw (new IllegalArgumentException("Invalid name specified"));

                    }
                }
            }
        }
        return result;
    }
   static boolean createDirectory(String path, FileSystemObject[] directory) {
       boolean result=false;
        String[] split = path.split("/");
        String[] children= new String[50];
        FolderObject folder = null;
        if(split.length==1){
            folder = new FolderObject(split[0],split[0],children);
            for (int i=0;i<directory.length;i++){
                if(directory[i]==null){
                    directory[i]=folder;
                    result = true;
                    break;
                }
            }
        } else if(split.length ==2){
            for(int i=0;i<directory.length;i++){
                if(directory[i]!=null){
                    if(directory[i].getName()==split[0]){
                        
                    }
                }
            }
        }
        return result;
    }

}
