/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.check;

import education.*;
import insurance.SocialInsuranceRecord;
import java.time.LocalDate;
import java.util.Calendar;
import personaldetails.*;

/**
 *
 * @author AlexT
 */
public class SocialInsuranceAccessCheck {

    public boolean checkEducation(Citizen person) {
        boolean check = false;
        for (Education education : person.getEducations()) {
            if (education != null && education.getDegree() == EducationDegree.Secondary) {
                if (education.isGraduated() == true) {
                    check = true;
                }
            }
        }
        return check;
    }

    public boolean checkSocialInsuranceInstallments(Citizen person) {
        boolean check = true;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        for (SocialInsuranceRecord socialInsurance : person.getSocialInsuranceRecords()) {
            int yearDifference = year - socialInsurance.getYear();
            if (yearDifference == 0 && month > 3) {
                if ((month - socialInsurance.getMonth()) <= 3) {
                    check = false;
                }
            } else if (yearDifference == 0 && month <= 3) {
                check = false;
            } else if (yearDifference == 1 && month <= 3) {
                if (((month + 12) - socialInsurance.getMonth()) < 3) {
                    check = false;
                }
            }
            break;
        }
        return check;
    }

    public double getSocialInsuranceInstallmentSum(Citizen person) {
        double sum = 0;
        int counter = 1;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        for (SocialInsuranceRecord socialInsurance : person.getSocialInsuranceRecords()) {
            int yearDifference = year - socialInsurance.getYear();
            if (yearDifference > -2) {
                sum = sum + socialInsurance.getAmount();
                counter++;
            } else if (yearDifference == -2 && socialInsurance.getMonth() >= month) {
                sum = sum + socialInsurance.getAmount();
                counter++;
            }
        }
        return sum / 24;
    }

}
