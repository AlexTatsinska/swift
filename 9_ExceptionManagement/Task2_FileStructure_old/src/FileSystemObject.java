/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public abstract class FileSystemObject {

    private String parent;
    private String name;

    FileSystemObject(String parent, String name) {
        this.parent = parent;
        this.name = name;
    }
    String getName() {
        return name;
    }
    String getParent() {
        return parent;
    }
    abstract boolean isParentExist(String name, FileSystemObject[] folder); 
    abstract boolean isNameExist(String name, FileSystemObject[] folder); 
       
}
