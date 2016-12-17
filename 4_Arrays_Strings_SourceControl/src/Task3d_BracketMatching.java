
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
public class Task3d_BracketMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        int check = 0;
        int count = 0;

        if (c.length % 2 != 0) {
            System.out.println("false");
        } else {
            for (int i = 0; i <c.length; i++) {
                if(c[i]=='{'){
                count=++count;    
                }
            }
            if (count%2 == 0){
                check = check+0;
                for (int i = 0; i <c.length; i++) {
                if(c[i]=='}'){
                count=++count;    
                }
            }
                if (count%2 == 0){
                check = check+0;
                } else {
                    check = ++check;
                }
            }
            for (int i = 0; i <c.length; i++) {
                if(c[i]=='['){
                count=++count;    
                }
            }
            if (count%2 == 0){
                check = check+0;
                for (int i = 0; i <c.length; i++) {
                if(c[i]==']'){
                count=++count;    
                }
            }
                if (count%2 == 0){
                check = check+0;
                } else {
                    check = ++check;
                }
            }
                for (int i = 0; i <c.length; i++) {
                if(c[i]=='('){
                count=++count;    
                }
            }
            if (count%2 == 0){
                check = check+0;
                for (int i = 0; i <c.length; i++) {
                if(c[i]==')'){
                count=++count;    
                }
            }
                if (count%2 == 0){
                check = check+0;
                } else {
                    check = ++check;
                }
            }
                //for (int j = (c.length - 1); j >=0; j--) {
                    
                    
                   /* if (c[i] == '{') {
                        if (c[j] == '}') {
                            check = check + 0;
                        }
                    } else {
                        check = check + 1;
                    }
                    if (c[i] == '(') {
                        if (c[j] == ')') {
                            check = check + 0;
                        }
                    } else {
                        check = check + 1;
                    }

                    if (c[i] == '[') {
                        if (c[j] == ']') {
                            check = check + 0;
                        }
                    } else {
                        check = check + 1;
                    }
                }
            }*/
            if (check != 0) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
        

    
        }
    }
    
}
