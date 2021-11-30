

package com.company.main;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.AbstractDAO;
import com.company.entity1.Country;
import com.company.entity1.EmploymentHistory;
import com.company.entity1.User;
import com.company.entity1.UserSkill;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main extends AbstractDAO
{    
    public static void main(String[] args) throws Exception {
           Context.instanceUserDao().getById("6");
          }
    
 public static List<User> lop(){
     return new ArrayList();
 }
}
