
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
public class SwiftDate {

    short year;
    byte month;
    byte day;

    SwiftDate() {
        Scanner sc = new Scanner(System.in);
        year = sc.nextShort();
        month = sc.nextByte();
        day = sc.nextByte();
    }

    boolean isLeapYear() {
        boolean isLeapYear;
        isLeapYear = (year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        return isLeapYear;
    }

    int getCentury() {
        int century;
        century = 1 + (year / 100);
        return century;
    }

    int getDaysDiference(SwiftDate other) {
        int daysDiference = 0;
        int monthDiferenceDays = 0;

        if (year > other.year) {
            for (int i = other.year; i <= year; i++) {
                if (((i % 4 == 0 && i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) == true) {
                    daysDiference = daysDiference + 366;
                } else {
                    daysDiference = daysDiference + 365;
                }
            }
            for (int i = month; i <= 12; i++) {
                if (((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) == true) {
                    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
                        monthDiferenceDays = monthDiferenceDays + 31;
                    } else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                        monthDiferenceDays = monthDiferenceDays + 30;
                    } else if (month == 2) {
                        monthDiferenceDays = monthDiferenceDays + 29;
                    }
                } else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
                    monthDiferenceDays = monthDiferenceDays + 31;
                } else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                    monthDiferenceDays = monthDiferenceDays + 30;
                } else if (month == 2) {
                    monthDiferenceDays = monthDiferenceDays + 28;
                }
            }

            daysDiference = daysDiference - monthDiferenceDays + day + 1;
            monthDiferenceDays = 0;
            for (int i = 1; i < other.month; i++) {
                if (((other.year % 4 == 0 && other.year % 400 == 0) || (other.year % 4 == 0 && other.year % 100 != 0)) == true) {
                    if ((other.month == 1) || (other.month == 3) || (other.month == 5) || (other.month == 7) || (other.month == 8) || (other.month == 10) || (other.month == 12)) {
                        monthDiferenceDays = monthDiferenceDays + 31;
                    } else if ((other.month == 4) || (other.month == 6) || (other.month == 9) || (other.month == 11)) {
                        monthDiferenceDays = monthDiferenceDays + 30;
                    } else if (other.month == 2) {
                        monthDiferenceDays = monthDiferenceDays + 29;
                    }
                } else if ((other.month == 1) || (other.month == 3) || (other.month == 5) || (other.month == 7) || (other.month == 8) || (other.month == 10) || (other.month == 12)) {
                    monthDiferenceDays = monthDiferenceDays + 31;
                } else if ((other.month == 4) || (other.month == 6) || (other.month == 9) || (other.month == 11)) {
                    monthDiferenceDays = monthDiferenceDays + 30;
                } else if (other.month == 2) {
                    monthDiferenceDays = monthDiferenceDays + 28;
                }
            }

            daysDiference = daysDiference - monthDiferenceDays - other.day;
        } else {
            for (int i = year; i <= other.year; i++) {
                if (((i % 4 == 0 && i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) == true) {
                    daysDiference = daysDiference + 366;
                } else {
                    daysDiference = daysDiference + 365;
                }
            }
            for (int i = other.month; i <= 12; i++) {
                if (((other.year % 4 == 0 && other.year % 400 == 0) || (other.year % 4 == 0 && other.year % 100 != 0)) == true) {
                    if ((other.month == 1) || (other.month == 3) || (other.month == 5) || (other.month == 7) || (other.month == 8) || (other.month == 10) || (other.month == 12)) {
                        monthDiferenceDays = monthDiferenceDays + 31;
                    } else if ((other.month == 4) || (other.month == 6) || (other.month == 9) || (other.month == 11)) {
                        monthDiferenceDays = monthDiferenceDays + 30;
                    } else if (other.month == 2) {
                        monthDiferenceDays = monthDiferenceDays + 29;
                    }
                } else if ((other.month == 1) || (other.month == 3) || (other.month == 5) || (other.month == 7) || (other.month == 8) || (other.month == 10) || (other.month == 12)) {
                    monthDiferenceDays = monthDiferenceDays + 31;
                } else if ((other.month == 4) || (other.month == 6) || (other.month == 9) || (other.month == 11)) {
                    monthDiferenceDays = monthDiferenceDays + 30;
                } else if (other.month == 2) {
                    monthDiferenceDays = monthDiferenceDays + 28;
                }
            }

            daysDiference = daysDiference - monthDiferenceDays + other.day;
            monthDiferenceDays = 0;
            for (int i = 1; i < month; i++) {
                if (((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) == true) {
                    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
                        monthDiferenceDays = monthDiferenceDays + 31;
                    } else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                        monthDiferenceDays = monthDiferenceDays + 30;
                    } else if (month == 2) {
                        monthDiferenceDays = monthDiferenceDays + 29;
                    }
                } else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
                    monthDiferenceDays = monthDiferenceDays + 31;
                } else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                    monthDiferenceDays = monthDiferenceDays + 30;
                } else if (month == 2) {
                    monthDiferenceDays = monthDiferenceDays + 28;
                }
            }

            daysDiference = daysDiference - monthDiferenceDays - day;
        }
        return daysDiference;
    }

    void printInfo() {
        
        if (isLeapYear() == true) {
            System.out.println(year + " " + month + " " + day + " -" + getCentury() + " century. It is LEAP year.");
        } else {
            System.out.println(year + " " + month + " " + day + " -" + getCentury()+"century");
        }
    }
}
