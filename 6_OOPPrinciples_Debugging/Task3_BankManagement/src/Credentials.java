/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Credentials {

    protected String userName;
    protected String password;

    protected Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    boolean checkPassword(String inputPassword) {
        boolean result;
        if (this.password.equals(inputPassword)) {
            result = true;

        } else {
            result = false;
        }
        return result;
    }
}
