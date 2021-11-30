
package com.company.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.Date;
import com.company.entity1.User;
import com.company.entity1.EmploymentHistory;
import java.sql.ResultSet;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.AbstractDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter
{
    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
     
           EntityManager em =em();
     try{
     Query query =em.createQuery("Select eh from EmploymentHistory eh");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }finally{
          em.close();
    }
    }
    
    @Override
    public EmploymentHistory getEmploymentHistoryByUserId(final int userId) {
       
            try{
         return (EmploymentHistory) super.getById(userId,EmploymentHistory.class);
        }catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean updateEmploymentHistory(final EmploymentHistory eh) throws Exception {
       try{
         super.update(eh);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int userId) {
       try{
         super.remove(userId,EmploymentHistory.class);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory employmentHistory) {
         try{
         super.add(employmentHistory);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         }
    
    
}
