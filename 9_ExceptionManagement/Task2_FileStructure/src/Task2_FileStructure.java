
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
        int counter = 1;
        while (!input.equals("END")) {
            String[] split = input.split(" ");
            String command = split[0];
            String path = split[1];

            if (command.equals("mkdir")) {
                createDirectory(path, directory, counter);
            }
            input = sc.nextLine();
            counter++;
        }
    }

    static boolean checkFolderName(String name) {
        boolean result = false;
        String check = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz";
        char[] nameArr = name.toCharArray();

        if (name.length() > 0 && name != null) {
            for (int i = 0; i < nameArr.length; i++) {
                if (i > 0) {
                    check = check + "()_!.&";
                    String checkName = "" + nameArr[i];
                    result = check.contains(checkName);
                } else if (i == 0) {
                    String checkName = "" + nameArr[i];
                    result = check.contains(checkName);
                }
            }
        }
        return result;
    }

    static void createDirectory(String path, FileSystemObject[] directory, int counter) {
        boolean result = false;
        String[] split = path.split("/");
        String[] children = new String[50];
        FolderObject folder = null;
        if (split.length == 1) {
            try {
                if (checkFolderName(split[0]) == true) {
                    folder = new FolderObject(split[0], split[0], children);
                    for (int i = 0; i < directory.length; i++) {
                        if (directory[i] == null) {
                            directory[i] = folder;
                            result = true;
                            break;
                        }
                    }
                } else {
                    throw (new IllegalArgumentException("Invalid name specified"));
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(counter + " Invalid name specified");
            }

        } else if (split.length > 1) {
            for (int i = 0; i < directory.length; i++) {
                if (directory[i] != null) {
                    if (directory[i].isParentExist(split[0], directory)) {
                        for (int j = 0; j < split.length; j++) {                            
                            if (directory[i].isNameExist(split[1], directory)) {
                                try {
                                    if (checkFolderName(split[j]) == true) {                                        
                                        for(int k=2;k<split.length;k++){
                                           children[k-2]=split[j];                                           
                                        }
                                        folder = new FolderObject(split[0], split[1], children);
                                        directory[i]=folder;

                                    } else {
                                        throw (new IllegalArgumentException("Invalid name specified"));
                                    }
                                } catch (IllegalArgumentException ex) {
                                    System.out.println(counter + " Invalid name specified");
                                }
                            } else{
                                
                                
                            }
                        }

                        break;
                    }
                }
            }
        }

    }

    

}
