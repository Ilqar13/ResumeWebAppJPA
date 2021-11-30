// 
// Decompiled by Procyon v0.5.36
// 

package com.company.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.company.entity1.Skill;
import com.company.entity1.User;
import com.company.entity1.UserSkill;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.dao.inter.AbstractDAO;
import com.company.main.Context;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter
{
    
        @Override
    public List<UserSkill> getAllSkillByUserId(final int userId) {
        EntityManager em =em();
        try{
       Query query =em.createQuery("Select us from UserSkill us where us.user.id=:uId",UserSkill.class);
       query.setParameter("uId", userId);
       List<UserSkill> list=query.getResultList();
       return list;
        } catch (Exception ex) {
            System.err.println(ex);
          return null;
        }finally{
            em.close();
        }
    }
    
     @Override
    public UserSkill getUserSkill(User user, Skill skill) {
        EntityManager em=em();
        try{
       Query query =em.createQuery("Select us from UserSkill us where us.skill=:s and us.user=:u");
       query.setParameter("s",skill);
       query.setParameter("u",user);
       UserSkill us=(UserSkill) query.getResultList().get(0);
       return us;
        } catch (Exception ex) {
            System.err.println(ex);
          return null;
        }finally{
            em.close();
        }
         }
    
    @Override
    public boolean insertUserSkill(final UserSkill us) {
        try {
           super.add(us);
           return true;
        }
        catch (Exception ex) {
            System.err.println(ex);
          return false;
        }
    }
    @Override
    public boolean insertUserSkillList(List<? extends UserSkill> userSkillList) {
       try{
            for (UserSkill us:userSkillList) {
                insertUserSkill(us);
            }
            return true;
        }
        catch (Exception ex) {
           ex.printStackTrace();
           return false;
        }
    }
    
    @Override
    public boolean updateUserPower(final int power, final int user_id, final int skill_id) {
        try {
         UserSkill us=getUserSkill(new User(user_id),new Skill(skill_id,null));
         us.setPower(power);
         us.setId(159);
         super.update(us);
         return true;
        }
        catch (Exception ex) {
            System.err.println(ex);
           return false;
        }
    }
    
    @Override
    public boolean removeUserSkill(final UserSkill userSkill) {
        try {
            super.remove(userSkill.getId(), UserSkill.class);
            return true;
             }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeAllUserSkills(int userId) {
        try{
            for (UserSkill us:this.getAllSkillByUserId(userId)) {
                removeUserSkill(us);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
            }
        }
    
        @Override
    public boolean checkUserSkill(final int user_id, final int skill_id) {
        EntityManager em =em();
        try {
         Query query =em.createQuery("Select COUNT(us.id) amount from UserSkill us where us.user.id=:uId and us.skill.id=:sId");
         query.setParameter("uId", user_id);
         query.setParameter("sId", skill_id);
         Long count=(Long) query.getResultList().get(0);
         return count==0;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserSkill> turnToUserSkillList(int userId, String[] skillIds, String[] skillPercents) {
        List<UserSkill> userSkillList=new ArrayList<>();
        
        for (int i = 0; i < skillIds.length; i++) {
            Integer skillId=Integer.parseInt(skillIds[i].replace("x", ""));
               if(!skillPercents[i].isEmpty())
            userSkillList.add(new UserSkill(null,new User(userId),new Skill(skillId,
                    Context.instanceSkillDao().getSkillNameById(skillId))
                    ,Integer.parseInt(skillPercents[i].replace("%","").trim())));
        }
        return userSkillList;
    }

}
