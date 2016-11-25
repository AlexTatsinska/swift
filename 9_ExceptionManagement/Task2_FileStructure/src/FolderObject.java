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

    private String children[];

    public FolderObject(String parent, String name, String[] children) {
        super(parent, name);
        this.children = children;
    }

    String[] getChildren() {
        return children;
    }

    String setChildren(String children) {
        for (int i = 0; i < this.getChildren().length; i++) {
            for (int j = 0; j <= this.children.length - 1; j++) {
                this.children[i] = children;
            }
        }
        return children;
    }

    @Override
    void isExist(String name, FileSystemObject[] folder) {
        for (int i = 0; i < folder.length; i++) {
            if (folder[i] instanceof FolderObject) {
                if (folder[i].getName() == name) {
                    break;
                } else if(i==folder.length){
                    throw (new IllegalArgumentException("Directory does not exist"));
                }
            }
        }
    }
}
