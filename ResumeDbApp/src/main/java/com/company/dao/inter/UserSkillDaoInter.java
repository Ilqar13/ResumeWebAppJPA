//
// Decompiled by Procyon v0.5.36
//

package com.company.dao.inter;

import com.company.entity1.Skill;
import com.company.entity1.User;
import com.company.entity1.UserSkill;

import java.util.List;

public interface UserSkillDaoInter
{
    List<UserSkill> getAllSkillByUserId(final int userId);

    UserSkill getUserSkill(final User user, final Skill skill);

    boolean insertUserSkill(final UserSkill userSkill);

    boolean updateUserPower(final int power, final int userId, final int skillId);

    boolean removeUserSkill(final UserSkill userSkill);

    boolean removeAllUserSkills(int userId);

    boolean checkUserSkill(final int userId, final int skillId);

    boolean insertUserSkillList (final List<? extends UserSkill>userSkillList);

    List<UserSkill> turnToUserSkillList (final int userId,final String [] skillNames,final String[] skillPercents);
}
