
import java.lang.annotation.Annotation;
import java.util.Arrays;

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
        /*
        for (Annotation annotation : card.getClass().getDeclaredAnnotations()) {
            String classInfo = card.getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ") + 1) + " " + classInfo.substring(classInfo.indexOf(classInfo), classInfo.lastIndexOf(" ")) + " " + annotationInfo.substring(annotationInfo.lastIndexOf("=") + 1, annotationInfo.indexOf(")")));

        }
        for (Annotation annotation : card.getRank().getClass().getDeclaredAnnotations()) {
            String classInfo = card.getRank().getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ") + 1) + " " + classInfo.substring(classInfo.indexOf(classInfo), classInfo.lastIndexOf(" ")) + " " + annotationInfo.substring(annotationInfo.lastIndexOf("=") + 1, annotationInfo.indexOf(")")));

        }
        for (Annotation annotation : card.getSuit().getClass().getDeclaredAnnotations()) {
            String classInfo = card.getSuit().getClass().toString();
            String annotationInfo = annotation.toString();
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ") + 1) + " " + classInfo.substring(classInfo.indexOf(classInfo), classInfo.lastIndexOf(" ")) + " " + annotationInfo.substring(annotationInfo.lastIndexOf("=") + 1, annotationInfo.indexOf(")")));

        }*/
        printInfo(card.getClass().getDeclaredAnnotations(), card.getClass().toString(), Arrays.toString(card.getClass().getDeclaredAnnotations()));
        printInfo(card.getRank().getClass().getDeclaredAnnotations(), card.getSuit().getClass().toString(), Arrays.toString(card.getRank().getClass().getDeclaredAnnotations()));
        printInfo(card.getSuit().getClass().getDeclaredAnnotations(), card.getRank().getClass().toString(), Arrays.toString(card.getSuit().getClass().getDeclaredAnnotations()));

    }

    static void printInfo(Annotation[] annotations, String classInfo, String annotationInfo) {
        for (Annotation annotation : annotations) {
            System.out.println(classInfo.substring(classInfo.lastIndexOf(" ") + 1) + " " + classInfo.substring(classInfo.indexOf(classInfo), classInfo.lastIndexOf(" ")) + " " + annotationInfo.substring(annotationInfo.lastIndexOf("=") + 1, annotationInfo.indexOf(")")));
        }
    }
}
