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
                switch (month) {
                    case 1:
                        if (socialInsurance.getMonth() > 9) {
                            check = false;
                        }
                        break;

                    case 2:
                        if (socialInsurance.getMonth() > 10) {
                            check = false;
                        }
                        break;
                    case 3:
                        if (socialInsurance.getMonth() > 11) {
                            check = false;
                        }
                        break;
                }
            }
            break;
        }
        return check;
    }

}
