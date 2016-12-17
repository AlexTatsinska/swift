/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class FileObject extends FileSystemObject {
    public FileObject(String parent, String name) {
        super(parent, name);
    }
    @Override
    boolean isParentExist(String name, FileSystemObject[] folder) throws IllegalArgumentException { 
        return true;
    }
    @Override
    boolean isNameExist(String name, FileSystemObject[] folder) throws IllegalArgumentException { 
        return true;
    }

}
