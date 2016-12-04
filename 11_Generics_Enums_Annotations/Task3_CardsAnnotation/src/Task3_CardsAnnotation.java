
import java.lang.annotation.Annotation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Task3_CardsAnnotation {

    public static void main(String[] args) {
        Card card = new Card(CardRank.King, CardSuit.Diamonds);

        //String result = card.getClass().getAnnotations().toString();
        //System.out.println(result);
        System.out.println(card.getClass());
        System.out.println(card.getRank().getClass());
        System.out.println(card.getSuit().getClass());
    }

}
