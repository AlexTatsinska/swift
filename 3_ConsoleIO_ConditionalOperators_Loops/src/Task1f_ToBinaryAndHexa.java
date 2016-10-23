
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
public class Task1f_ToBinaryAndHexa {
    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int c = number;
        String binaryNum = "";
        
        while (number!=0){
            if (number%2 == 0){
                
               // System.out.println("0"+binaryNum);
                binaryNum = "0"+binaryNum;
                number = number/2;
            } else{
                
               // System.out.println("1"+binaryNum);
                binaryNum = "1"+binaryNum;
                number = number/2;
            }
            
        }
        System.out.println(binaryNum);
        System.out.println("");
        /*
        while (c != 0){
            c = c%16;
            
            
                switch (c){
                case 10:
                System.out.print("A"); 
                c=c/16;
                break;
                case 11:
                    System.out.print("B");
                    c=c/16;
                    break;
                case 12:
                    System.out.print("C");
                    c=c/16;
                    break;
                case 13:
                    System.out.print("D");
                    c=c/16;
                    break;
                case 14:
                    System.out.print("E");
                    c=c/16;
                    break;
                case 15:
                    System.out.print("F");
                    c=c/16;
                    break;
                default:
                  if (c <= 9){
                System.out.print(c);
                c=c/16;
                  }
                    break;
            }
                
        }*/
            
    
    
}
}
