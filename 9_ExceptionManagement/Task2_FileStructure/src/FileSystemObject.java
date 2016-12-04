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

    private FileSystemObject parent;
    private String name;

    FileSystemObject(FileSystemObject parent, String name) {
        if (checkName(name) == false) {
            throw (new IllegalArgumentException("Invalid name specified"));            
        } else {
            this.parent = parent;
            this.name = name;
        }
    }

    String getName() {
        return name;
    }

    FileSystemObject getParent() {
        return parent;
    }

    boolean checkName(String name) {
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

}
