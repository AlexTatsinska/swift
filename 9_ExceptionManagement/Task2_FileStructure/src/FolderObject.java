
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
public class FolderObject extends FileSystemObject {
     public List<FileSystemObject> children;

    public FolderObject(FolderObject parent, String name) {   
        super(parent, name);
        this.children = new ArrayList<>();       
    }

    List<FileSystemObject> getChildren() {
        return children;
    }

    void addChild(FileSystemObject obj){
        children.add(obj);
    }

   
    
}
