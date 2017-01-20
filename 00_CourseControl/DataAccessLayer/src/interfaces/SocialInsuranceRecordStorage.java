package interfaces;

import exception.DALException;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;
import java.util.List;

public interface SocialInsuranceRecordStorage {
    
     public void insertSocialInsurance(List <SocialInsuranceRecord> socialInsurances, int personId) throws DALException;
     public List<SocialInsuranceRecord> getSocialInsuranceByPersonId(int personId) throws DALException;
     public void insertSocialInsuranceFromWebPage(SocialInsuranceRecord socialInsurance, int person_id) throws DALException;
}
