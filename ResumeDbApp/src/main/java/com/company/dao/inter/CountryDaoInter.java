//
// Decompiled by Procyon v0.5.36
//

package com.company.dao.inter;

import com.company.entity1.Country;

import java.util.List;

public interface CountryDaoInter
{
    List<Country> getAllCountry();

    Integer getIdByName(final String name);

    Integer getIdByNationality(final String nationality);

}
