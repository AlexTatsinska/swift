
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Task3_BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputInfo = "";
        String input = sc.nextLine();
        Bank bank = new Bank();
        
        while (!"END".equals(input)) {
            inputInfo = inputInfo + ";" + input;
            input = sc.nextLine();
        }
        String[] splitInputInfo = inputInfo.split(";");
        for (int i =0;i<splitInputInfo.length;i++){
            String[] split = splitInputInfo[i].split(" ");
            String command = split[0];
            String userName;
            String password;
            String name;
            String govId;
            double amount;
            String recipient;
            if (command.equals("OPEN")){//<username> <password> <name> <govId>
                userName = split[1];
                password = split[2];
                name = split[3];
                govId = split[4];
                bank.openAccount(name, govId, userName, password);
            }
            if (command.equals("CLOSE")){//CLOSE <username> <password>
                userName = split[1];
                password = split[2];
                bank.closeAccount(userName, password);
            }
            if (command.equals("DEPOSIT")){//DEPOSIT <username> <amount>
                userName = split[1];
                amount = Double.parseDouble(split[2]);
                bank.deposit(userName, amount);
            }
            if(command.equals("WITHDRAW")){//WITHDRAW <username> <password> <amount>
                userName = split[1];
                password = split[2];
                amount = Double.parseDouble(split[3]);
                bank.withdraw(userName, password, amount);
            }
            if(command.equals("TRANSFER")){//TRANSFER <username> <password> <amount> <recipient>
                userName = split[1];
                password = split[2];
                amount = Double.parseDouble(split[3]);
                recipient = split[4];
                bank.transfer(userName, password, amount, recipient);
            }
           
        }
        System.out.printf("%.2f", bank.getAssets());
        System.out.println();
        bank.getAccountInfo();
        
    }
    
}
