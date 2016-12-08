
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
        
       // System.out.println(card.getClass());
        //System.out.println(card.getRank().getClass());
        //System.out.println(card.getSuit().getClass());

        for (Annotation annotation : card.getClass().getDeclaredAnnotations()) {
            String classInfo = card.getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ")+1)+" "+classInfo.substring(classInfo.indexOf(classInfo),classInfo.lastIndexOf(" "))+" "+annotationInfo.substring(annotationInfo.lastIndexOf("=")+1, annotationInfo.indexOf(")")));
            
        }
        for (Annotation annotation : card.getRank().getClass().getDeclaredAnnotations()) {
            String classInfo = card.getRank().getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ")+1)+" "+classInfo.substring(classInfo.indexOf(classInfo),classInfo.lastIndexOf(" "))+" "+annotationInfo.substring(annotationInfo.lastIndexOf("=")+1, annotationInfo.indexOf(")")));
            
        }
        for (Annotation annotation : card.getSuit().getClass().getDeclaredAnnotations()) {
            String classInfo = card.getSuit().getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ")+1)+" "+classInfo.substring(classInfo.indexOf(classInfo),classInfo.lastIndexOf(" "))+" "+annotationInfo.substring(annotationInfo.lastIndexOf("=")+1, annotationInfo.indexOf(")")));
            
        }
    }

}
