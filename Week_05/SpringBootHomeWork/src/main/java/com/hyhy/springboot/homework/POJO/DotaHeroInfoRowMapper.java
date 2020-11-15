package com.hyhy.springboot.homework.POJO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DotaHeroInfoRowMapper implements RowMapper<DotaHeroInfo> {
    @Override
    public DotaHeroInfo mapRow(ResultSet rs, int i) throws SQLException {
        String name = rs.getString("name");
        Integer strength = rs.getInt("strength");
        Integer agility = rs.getInt("agility");
        Integer intelligence = rs.getInt("intelligence");
        int is_carry = rs.getInt("is_carry");
        if (is_carry == 0) {
            return new DotaHeroInfo(name,strength,agility,intelligence,false);
        } else {
            return new DotaHeroInfo(name,strength,agility,intelligence,true);
        }
    }
}
