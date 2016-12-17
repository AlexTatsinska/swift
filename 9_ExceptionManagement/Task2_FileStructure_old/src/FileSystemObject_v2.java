/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public abstract class FileSystemObject_v2 {

    private FileSystemObject_v2 parent;
    private String name;

    FileSystemObject_v2(FileSystemObject_v2 parent, String name) {
        this.parent = parent;
        this.name = name;
    }
    String getName() {
        return name;
    }
    FileSystemObject_v2 getParent() {
        return parent;
    }
    
    //abstract boolean isParentExist(String name, FileSystemObject[] folder); 
    //abstract boolean isNameExist(String name, FileSystemObject[] folder); 
       
}
