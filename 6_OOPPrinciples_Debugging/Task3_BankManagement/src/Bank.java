/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Bank {

    protected Account[] accountArr = new Account[5];
    protected double assets;

    void openAccount(String name, String govId, String userName, String password) {//void openAccount(name, govId, username, password) - Отваря сметка с въведените данни

        for (int i = 0; i < accountArr.length; i++) {

            if ((accountArr[i] != null) && (i == accountArr.length - 1)) {
                System.out.println("OPEN fail");

            } else if (accountArr[i] == null) {
                double balance = 0;
                accountArr[i] = new Account(name, govId, balance, userName, password);
                System.out.println("OPEN success");
                i = accountArr.length;
            }
        }
    }

    void closeAccount(String userName, String password) {//void closeAccount(username, password) - Затваря сметка, ако потребителското име и паролата съвпадат
        for (int i = 0; i < accountArr.length; i++) {
            if (accountArr[i] != null) {
                if ((userName.equals(accountArr[i].getUserName()) && (accountArr[i].hasAccess(password)))) {
                    accountArr[i] = null;
                    for (int j = i + 1; j < accountArr.length; j++) {
                        accountArr[i] = accountArr[j];
                    }
                    System.out.println("CLOSE success");
                } else if ((userName.equals(accountArr[i].getUserName()) && (accountArr[i].hasAccess(password))) && (i == accountArr.length - 1)) {

                    System.out.println("CLOSE fail");
                }
            }

        }
    }

    void deposit(String userName, double amount) {//void deposit(username, amount) - Увеличава баланса на сметка с потребител username с amount
        for (int i = 0; i < accountArr.length; i++) {
            if (amount > 0) {
                if (accountArr[i] != null) {
                    if (userName.equals(accountArr[i].getUserName())) {
                        accountArr[i].deposit(amount);
                        assets = assets + amount;
                        System.out.println("DEPOSIT success");
                        i = accountArr.length;

                    } else if (i == accountArr.length - 1) {
                        System.out.println("DEPOSIT fail");
                    }
                }
            } else{
                 System.out.println("DEPOSIT fail");
                 i = accountArr.length;
            }
        }
    }

    void withdraw(String userName, String password, double amount) {  //void withdraw(username, password, amount) 
        //Намалява баланса на сметка с потребител username с amount, ако паролата съвпада. Amount трябва да е по-малък от текущия баланс.
        for (int i = 0; i < accountArr.length; i++) {
            if (accountArr[i] != null) {
                if ((userName.equals(accountArr[i].getUserName()) && (accountArr[i].hasAccess(password)))) {
                    if (accountArr[i].getBalance() > amount) {
                        accountArr[i].withdraw(amount);
                        assets = assets - amount;
                        System.out.println("WITHDRAW success");
                        i = accountArr.length;
                    }
                } else if (i == accountArr.length - 1) {
                    System.out.println("WITHDRAW fail");
                }
            }            
        }
    }

    void transfer(String userName, String password, double amount, String recipient) {//void transfer(username, password, amount, recipient) 
        //Намалява баланса на username и увеличава този на recipient с amount, ако паролите съвпадат. Amount трябва да е по-малък от текущия баланс.
        for (int i = 0; i < accountArr.length; i++) {
            if (accountArr[i] != null) {
                if ((userName.equals(accountArr[i].getUserName()) && (accountArr[i].hasAccess(password)))) {
                    if (accountArr[i].getBalance() > amount) {
                        for (int j = 0; j < accountArr.length; j++) {
                            if (recipient.equals(accountArr[j].user.userName)) {
                                withdraw(userName, password, amount);
                                deposit(recipient, amount);
                                System.out.println("TRANSFER success");
                                i = accountArr.length;
                            }
                        }
                    } else if (i == accountArr.length - 1) {
                        System.out.println("TRANSFER fail");
                    }
                }
            }
        }
    }

    double getAssets() {//double getAssets() - Връща активите на банката. 
        return assets;
    }

    void getAccountInfo() {
        String accountInfo = "";
        for (int i = 0; i < accountArr.length; i++) {
            if (accountArr[i] != null) {
                accountInfo = String.format("%s,%s,%.2f%n", accountArr[i].getName(), accountArr[i].getGovId(), accountArr[i].getBalance());
                System.out.println(accountInfo);
            }
        }
    }

}
