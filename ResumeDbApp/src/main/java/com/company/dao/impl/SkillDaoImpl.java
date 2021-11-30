// 
// Decompiled by Procyon v0.5.36
// 

package com.company.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.company.entity1.Skill;
import java.sql.ResultSet;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.AbstractDAO;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter
{
    
    @Override
    public List<Skill> getAllSkill() {
     EntityManager em =em();
     try{
     Query query =em.createQuery("Select s from Skill s");
     return query.getResultList();
     }catch(Exception ex){
        ex.printStackTrace();
        return null;
     }finally{
          em.close();
     }
    }
    
    @Override
    public Skill getById(final int userId) {
       try{
          return (Skill) super.getById(userId,Skill.class);
       }catch(Exception ex){
           ex.printStackTrace();
           return null;
       }
    }
    
     @Override
    public String getSkillNameById(int id) {
        EntityManager em =em();
        Query query =em.createQuery("Select s.name from Skill s where s.id=:id");
        query.setParameter("id", id);
        return (String) query.getResultList().get(0);
        }
    
    @Override
    public boolean updateSkill(final Skill skill) {
        boolean b = true;
        try {
            super.update(skill);
        }
        catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }
    
    @Override
    public boolean insertSkill(final Skill skill) {
        try {
          super.add(skill);
          return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public int getIdByName(final String name) {
         EntityManager em=em();
        try {
            Query query =em.createQuery("Select s.id from Skill s where s.name=:name");
            query.setParameter("name",name);
            return (int) query.getResultList().get(0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }finally{
            em.close();
        }
    }
    
    @Override
    public boolean removeSkill(final int id) {
        try {
            super.remove(id, Skill.class);
            return true;
                    }
        catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    @Override
    public Skill getByName(final String name) {
         EntityManager em=em();
         try {
            Query query =em.createQuery("Select s from Skill s where s.name=:name");
            query.setParameter("name", name);
             return null;
        }finally{
             em.close();
         }
    }
    
    @Override
    public long countSkill() {
         EntityManager em=em();
       try {
            Query query =em.createQuery("Select COUNT(s.name) from Skill s");
            return (long) query.getResultList().get(0);
       } catch (Exception ex){
            ex.printStackTrace();
             return 0;
        }finally{
            em.close();
       }
    }
   
       @Override
      public boolean checkId(final int id) {
          EntityManager em=em();
        try {
            Query query =em.createQuery("Select COUNT(s.name) from Skill s where s.id=:id");
            query.setParameter("id", id);
            if((Long)query.getResultList().get(0)==0){
                return true;
            }else{
                return false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
             return false;
        }finally{
            em.close();
       }
    }

}
