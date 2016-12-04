
import java.util.ArrayList;
import java.util.List;
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
        int lineCounter = 1;
        List<FileSystemObject> directory = new ArrayList<>();
        FolderObject root = new FolderObject(null, "newFolder");

        while (!input.equals("END")) {
            String[] split = input.split(" ");
            String command = split[0];
            String path = split[1];

            if (command.equals("mkdir")) {
                try {

                    int lastSeparatorIndex = path.lastIndexOf("/");

                    if (lastSeparatorIndex == -1) {
                        root.addChild(new FolderObject(root, path));
                        directory.add(root);

                    } else {
                        System.out.println(path.substring(0));
                        FolderObject folder = findFolder(path.substring(0), directory);
                        folder.addChild(new FolderObject(folder, path.substring(lastSeparatorIndex + 1)));
                        directory.add(folder);
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(lineCounter +" "+ ex);
                }
            }

            input = sc.nextLine();
            lineCounter++;
        }

    }

    private static FolderObject findFolder(String substring, List<FileSystemObject> directory) {
        String[] split = substring.split("/");
        for(int i =0;i<split.length-1;i++){
        if(directory.contains(split[i])){
            int index = directory.indexOf(split[i]);
            System.out.println((FolderObject) directory.get(index).getParent()+" "+directory.get(index).getName());
            FolderObject folder = new FolderObject((FolderObject) directory.get(index).getParent(),directory.get(index).getName());            
            return folder;                
        }       
        }
        throw (new IllegalArgumentException("Directory does not exist"));
    }

}
