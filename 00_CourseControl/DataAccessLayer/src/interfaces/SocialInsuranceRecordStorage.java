package interfaces;

import insurance.SocialInsuranceRecord;
import java.sql.SQLException;

public interface SocialInsuranceRecordStorage {
    
     public void insertSocialInsurance(SocialInsuranceRecord socialInsurance) throws SQLException;
    
}
