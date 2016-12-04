/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Task1_Cards {

    public static void main(String[] args) {
        String result = "";
        for (CardSuit cardSuit : CardSuit.values()) {
            result = result + ", " + cardSuit;

        }
        
        System.out.println(result.substring(2, result.length()));
        
        result = "";
        
        for (CardRank cardRank : CardRank.values()) {
            result = result + ", " + cardRank;
        }
        System.out.println(result.substring(2, result.length()));
    }
}
