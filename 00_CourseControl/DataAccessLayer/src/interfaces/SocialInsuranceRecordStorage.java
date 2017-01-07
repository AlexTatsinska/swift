package interfaces;

import exception.DALException;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;

public interface SocialInsuranceRecordStorage {
    
     public void insertSocialInsurance(SocialInsuranceRecord socialInsurance) throws DALException;
    
}
