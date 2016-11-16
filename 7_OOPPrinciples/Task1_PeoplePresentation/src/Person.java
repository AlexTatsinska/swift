/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Person {

    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    boolean checkFirstNameBegin(String firstName) {
        boolean result = false;
        char[] fName = firstName.toCharArray();
        String alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        char[] checkFirstLetter = alphabet.toCharArray();
        for (int i = 0; i < checkFirstLetter.length; i++) {
            if (checkFirstLetter[i] == fName[0]) {
                result = true;
            }
            if ((i == checkFirstLetter.length - 1) && (result == false)) {
                result = false;
            }
        }
        return result;
    }

    boolean checkNameLength(String firstName) {
        boolean result = false;
        if (firstName.length() >= 2 && firstName.length() <= 30) {
            result = true;
        }
        return result;
    }

    boolean checkNameEssence(String firstName) {
        /*boolean result = false;
        char[] fName = firstName.toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] checkSmallLetter = alphabet.toCharArray();
        for (int i = 0; i < fName.length; i++) {
            for (int j = 0; j < checkSmallLetter.length; j++) {
                if (fName[i] == checkSmallLetter[j]) {
                    result = true;
                    //j=checkSmallLetter.length;
                } else if ((j == checkSmallLetter.length - 1) && (result == false)) {
                    result = false;
                    i=fName.length;
                }
            }
        }*/
        return firstName.matches("[\\p{Alpha} ]+");
    }

    boolean checkNameBegin(String lastName) {
        boolean result = false;
        char[] lName = lastName.toCharArray();
        String alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        char[] checkFirstLetter = alphabet.toCharArray();
        for (int i = 0; i < checkFirstLetter.length; i++) {
            if (checkFirstLetter[i] == lName[0]) {
                result = true;
            }
            if ((i == checkFirstLetter.length - 1) && (result == false)) {
                result = false;
            }
        }
        return result;
    }

    /* boolean checkFirstName(String firstName) {
        boolean result = true;
        char[] fName = firstName.toCharArray();
        String alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        char[] checkFirstLetter = alphabet.toCharArray();
        if ((fName.length >= 2) && (fName.length <= 30)) {
            for (int i = 0; i < checkFirstLetter.length; i++) {
                if (fName[0] == checkFirstLetter[i]) {
                    String alphabetLower = alphabet.toLowerCase();
                    char[] checkLowLetters = alphabetLower.toCharArray();
                    for (int j = 0; j < fName.length; j++) {
                        for (int k = 0; k < checkLowLetters.length; k++) {
                            if (fName[j] == checkLowLetters[k]) {
                                result = result && true;
                            }
                        }
                    }
                    i = checkFirstLetter.length;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    boolean checkLastName(String lastName) {
        boolean result = true;
        char[] lName = lastName.toCharArray();
        String alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        char[] checkFirstLetter = alphabet.toCharArray();
        if ((lName.length >= 2) && (lName.length <= 30)) {
            for (int i = 0; i < checkFirstLetter.length; i++) {
                if (lName[0] == checkFirstLetter[i]) {
                    String alphabetLower = alphabet.toLowerCase();
                    char[] checkLowLetters = alphabetLower.toCharArray();
                    for (int j = 0; j < lName.length; j++) {
                        for (int k = 0; k < checkLowLetters.length; k++) {
                            if (lName[j] == checkLowLetters[k]) {
                                result = result && true;
                            }
                        }
                    }
                    i = checkFirstLetter.length;
                }
            }
        } else {
            result = false;
        }
        return result;
    }*/
}
