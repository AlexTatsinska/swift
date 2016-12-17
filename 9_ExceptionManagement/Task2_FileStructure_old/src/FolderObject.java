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

    public String children[];

    public FolderObject(String parent, String name, String[] children) {
        super(parent, name);
        this.children = children;
    }

    String[] getChildren() {
        return children;
    }

    void setChildren(String children,FileSystemObject dyrectory) {       
        for (int i = 0; i < this.getChildren().length; i++) {
            for (int j = 0; j <= this.children.length - 1; j++) {
                this.children[i] = children;
            }
        }

    }

    @Override
    boolean isParentExist(String name, FileSystemObject[] folder) {
        boolean result = false;
        for (int i = 0; i < folder.length; i++) {
            if (folder[i] instanceof FolderObject) {
                if (folder[i].getParent() == name) {
                    result = true;
                    break;
                } else if (i == folder.length) {
                    result = false;
                }
            }
        }
        return result;
    }
    @Override
    boolean isNameExist(String name, FileSystemObject[] folder) {
        boolean result = false;
        for (int i = 0; i < folder.length; i++) {
            if (folder[i] instanceof FolderObject) {
                if (folder[i].getName() == name) {
                    result = true;
                    break;
                } else if (i == folder.length) {
                    result = false;
                }
            }
        }
        return result;
    }
}
