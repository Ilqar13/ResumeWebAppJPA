
package com.company.dao.impl;

import java.util.List;
import com.company.entity1.User;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.AbstractDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter
{

    EntityManager entityManager;


    @Override
    public User getById(final String userId) {
        try{
         return (User) super.getById(Integer.parseInt(userId),User.class);
        }catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
    }
    
//    @Override
//    public User getByGmail(String userGmail) {
//        EntityManager em =em();
//        Query query=em.createQuery("select u from User u where u.email= :e",User.class);
//        query.setParameter("e", userGmail);
//        List<User> list=query.getResultList();
//        em.close();
//        if(list.size()==1){
//            return list.get(0);
//        }
//        return null;
//    }
      
   
    @Override
    public User getByGmail(String userGmail) {
        EntityManager em =em();
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<User> cq=cb.createQuery(User.class);
        Root<User> postRoot =cq.from(User.class);
        cq.where(cb.equal(postRoot.get("email"),userGmail));
        Query query=em.createQuery(cq);
        List<User> list =query.getResultList();
        em.close();
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }
    
//        @Override
//    public User getByGmail(String userGmail) {
//        EntityManager em =em();
//        Query query=em.createNativeQuery("Select user_image from user u where u.email=? ");
//        query.setParameter(1, userGmail);
//        List<User> list=query.getResultList();
//        em.close();
//        if(list.size()==1){
//            return list.get(0);
//        }
//        return null;
//    }
    
    
    @Override
    public List<User> getAll(String name,String surname) {
        EntityManager em=em();
        String jpql ="Select u from User u where 1=1";
        try {
            if(name!=null && !name.isEmpty()){
            jpql+=" and u.name=:name";
            
            }
            if(surname!=null  && !surname.isEmpty()){
            jpql+=" and u.surname=:surname";
            }
            
            Query query=em.createQuery(jpql, User.class);
            
            if(jpql.contains("name"))
                query.setParameter("name", name);
            
            if(jpql.contains("surname"))
                query.setParameter("surname", surname);
            return query.getResultList();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }finally{
            em.close();
        }
    }
    
    @Override
    public boolean updateUser(final User u) {
         try{
         super.update(u);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeUser(final int id) {
        try{
         super.remove(id,User.class);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean addUser(final User u) {
         try{
         super.add(u);
         return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
