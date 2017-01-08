package interfaces;

import exception.DALException;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;
import java.util.List;

public interface SocialInsuranceRecordStorage {
    
     public void insertSocialInsurance(List <SocialInsuranceRecord> socialInsurances) throws DALException;
    
}
