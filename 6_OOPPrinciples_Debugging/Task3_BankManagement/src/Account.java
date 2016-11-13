/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Account {

    protected String name;
    protected String govId;
    protected double balance;
    protected Credentials user;

    protected Account(String name, String govId, double balance, String userName, String password) {
        this.name = name;
        this.govId = govId;
        this.balance = balance;
        this.user = new Credentials(userName, password);
    }

    void deposit(double amount) { //Увеличава баланса по сметка с amount
        balance = balance + amount;
    }

    void withdraw(double amount) {//Намаля баланса по сметка с amount 
        balance = balance - amount;
    }

    double getBalance() {//Връща баланса по сметка
        return balance;
    }

    boolean hasAccess(String password) {//Проверява дали подадената паролата съвпада със запазената
        return user.checkPassword(password);
    }

    String getUserName() {//Връща потребителското име по сметка
        return user.userName;
    }

    String getGovId() {//Връща ЕГН-то на потребителя по сметка
        return govId;
    }

    String getName() {//Връща името на потребителя по сметка
        return name;

    }

}
