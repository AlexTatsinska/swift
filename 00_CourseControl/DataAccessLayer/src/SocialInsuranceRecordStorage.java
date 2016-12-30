
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public interface SocialInsuranceRecordStorage {
     public void insertSocialInsurance(SocialInsuranceRecord socialInsurance) throws SQLException;
    
}
