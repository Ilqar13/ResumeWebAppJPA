//
// Decompiled by Procyon v0.5.36
//

package com.company.dao.inter;

import com.company.entity1.Skill;

import java.util.List;

public interface SkillDaoInter
{
    List<Skill> getAllSkill();


    Skill getById(final int skillId);

    String getSkillNameById(int id);

    boolean updateSkill(final Skill skill);

    boolean removeSkill(final int skillId);

    Skill getByName(final String user);

    boolean insertSkill(final Skill skill);

    long countSkill();

    int getIdByName(final String skillName);

    boolean checkId(final int skillId);

}
