
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Task2_CredentialsManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputInfo = "";
        String input = sc.nextLine();
        Credentials credential = null;
        Credentials[] credentialsArr = new Credentials[200];
        while (!"END".equals(input)) {
            inputInfo = inputInfo + ";" + input;
            input = sc.nextLine();
        }
        String[] splitInputInfo = inputInfo.split(";");
        for (int i = 0; i < splitInputInfo.length; i++) {
            String[] split = splitInputInfo[i].split(" ");
            String command = "";
            String userName;
            String password;
            String newPassword;
            if (split.length == 3) {
                command = split[0];
                userName = split[1];
                password = split[2];
                if (command.equals("ENROLL")) {
                    String[] pass = new String[100];
                    for (int j = 0; j < pass.length; j++) {
                        if (j == 0) {
                            pass[j] = password;
                        } else {
                            pass[j] = "null";
                        }

                    }
                    credential = new Credentials(userName, pass);
                    for (int k = 0; k < credentialsArr.length; k++) {
                        if (credentialsArr[k] == null) {
                            credentialsArr[k] = credential;
                            k = credentialsArr.length;
                            System.out.println("ENROLL success");
                        }
                    }
                }
                if (command.equals("AUTH")) {
                    for (int k = 0; k < credentialsArr.length; k++) {
                        if (credentialsArr[k] != null) {
                            if (userName.equals(credentialsArr[k].userName)) {
                                System.out.println(credentialsArr[k].checkPassword(password));
                            }
                        }
                    }
                }
            }
            if (split.length == 4) {
                command = split[0];
                userName = split[1];
                password = split[2];
                newPassword = split[3];
                if (command.equals("CHPASS")) {
                    for (int k = 0; k < credentialsArr.length; k++) {
                        if (credentialsArr[k] != null) {
                            if (userName.equals(credentialsArr[k].userName)) {
                                System.out.println(credentialsArr[k].changePass(newPassword));
                            }
                        }
                    }
                }
            }
        }
    }
}
