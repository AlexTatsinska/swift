
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
public class FolderObject_v2 extends FileSystemObject_v2 {

    public List<FileSystemObject_v2> children;

    public FolderObject_v2(FolderObject_v2 parent, String name) {
        super(parent, name);
        this.children = new ArrayList<>();
    }

    List<FileSystemObject_v2> getChildren() {
        return children;
    }

    void addChild(FileSystemObject_v2 obj){
        children.add(obj);
    }
    
}
