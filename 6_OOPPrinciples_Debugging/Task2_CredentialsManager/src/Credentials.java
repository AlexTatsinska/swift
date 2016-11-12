/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Credentials {

    protected String userName;
    protected String[] password;

    public Credentials(String userName, String[] password) {
        this.userName = userName;
        this.password = password;
    }

    String changePass(String newPassword) {
        String result = "";
        for (int i = 0; i < password.length; i++) {
            if (!password[i].equals("null")) {
                if (password[i].equals(newPassword)) {
                    result = "CHPASS fail";
                }
            } else if (password[i].equals("null")) {
                if (!result.equals("CHPASS fail")) {
                    password[i] = newPassword;
                    i = password.length;
                    result = "CHPASS success";
                }
            }
        }
        return result;
    }

    String checkPassword(String inputPassword) {
        String result = "";
        for (int i = password.length - 1; i >= 0; i--) {
            if (!password[i].equals("null")) {
                if (password[i].equals(inputPassword)) {
                    result = "AUTH success";
                    i = 0;
                } else {
                    result = "AUTH fail";
                    i = 0;
                }

            }
        }

        return result;
    }

    String getPassword() {
        String pass = "";
        for (int i = 0; i < password.length; i++) {
            pass = pass + " i=" + i + " " + password[i];
        }
        return pass;
    }
}
