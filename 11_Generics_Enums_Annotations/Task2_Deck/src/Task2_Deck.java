/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Task2_Deck {

    public static void main(String[] args) {
        Card[] deck = new Card[52];
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                for (int i = 0; i < deck.length; i++) {
                    if (deck[i] == null) {
                        deck[i] = new Card(rank, suit);
                        System.out.println(deck[i].toString());
                        break;
                    }
                }
            }
        }
    }
}
