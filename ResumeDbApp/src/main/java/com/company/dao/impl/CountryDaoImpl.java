 
 

package com.company.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;
import com.company.entity1.Country;
import java.sql.ResultSet;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.AbstractDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter
{
    
    @Override
    public List<Country> getAllCountry() {
        EntityManager em =em();
     try{
     Query query =em.createQuery("Select c from Country c");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }finally{
          em.close();
     }
    }
    
    @Override
    public Integer getIdByName(final String name) {
        EntityManager em=em();
         try {
            Query query =em.createQuery("Select c.id from Country c where c.name=:name");
               query.setParameter("name", name);
            return (Integer) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return null;
        }finally{
             em.close();
         }
    }
    
    @Override
    public Integer getIdByNationality(final String nationality) {
                EntityManager em=em();
         try {
            Query query =em.createQuery("Select c.id from Country c where c.nationality=:nationality");
               query.setParameter("nationality",nationality);
            return (Integer) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return null;
        }finally{
             em.close();
         }
           }
}
