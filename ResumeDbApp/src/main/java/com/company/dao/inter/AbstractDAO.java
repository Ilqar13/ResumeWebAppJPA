// 
// Decompiled by Procyon v0.5.36
// 

package com.company.dao.inter;

import com.company.entity1.Skill;

import java.io.Closeable;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class AbstractDAO
{
    private static final EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("resumeappPU");
    
    public Connection connection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/resume";
        final String username = "root";
        final String password = "ilqar2002";
        final Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    
    public  EntityManager em(){
         return emfactory.createEntityManager();
    }
    
    
    //I am aware of that, finalize method is unreliable but I couldnt have better solution in order to close object if App is off.
//    @Override
//    public void finalize(){
//        emfactory.close();
//    }
// 
    
    public Object getById(final int id,Class entityClass) {
        try{
        EntityManager entityManager =em();
        Object o=entityManager.find(entityClass,id);
        entityManager.close();
         return o;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean update(final Object o) {
         try{
         EntityManager entityManager =em();
         entityManager.getTransaction().begin();
         entityManager.merge(o);
         entityManager.getTransaction().commit();
         entityManager.close();
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean remove( int id,Class entityClass) {
        try{
         EntityManager entityManager =em();
         Object o=entityManager.find(entityClass, id);
         System.out.println(o);
         entityManager.getTransaction().begin();
         entityManager.remove(o);
         entityManager.getTransaction().commit();
         entityManager.close();
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean add(final Object o) {
         try{
         EntityManager entityManager =em();
         entityManager.getTransaction().begin();
         entityManager.persist(o);
         entityManager.getTransaction().commit();
         entityManager.close();
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
