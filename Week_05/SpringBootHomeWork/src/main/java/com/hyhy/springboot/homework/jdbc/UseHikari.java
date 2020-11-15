package com.hyhy.springboot.homework.jdbc;

import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import com.hyhy.springboot.homework.POJO.DotaHeroInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class UseHikari {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer insert(DotaHeroInfo info) {
        Integer isCarry = 0;
        if (info.getIsCarry()) {
            isCarry = 1;
        }
        String insertSQL = String.format(Constants.INSERT_BASE, info.getName(), info.getStrength(), info.getAgility(), info.getIntelligence(), isCarry);
        return jdbcTemplate.update(insertSQL);
    }

    public Integer delete(Integer id) {

        String deleteSQL = String.format(Constants.DELETE_BASE, id);
        return jdbcTemplate.update(deleteSQL);
    }

    public Integer update(Integer id, DotaHeroInfo newInfo) {
        Integer isCarry = 0;
        if (newInfo.getIsCarry()) {
            isCarry = 1;
        }
        String updateSQL = String.format(Constants.UPDATE_BASE,
                newInfo.getName(),
                newInfo.getStrength(),
                newInfo.getAgility(),
                newInfo.getIntelligence(),
                isCarry,
                id
        );
        return jdbcTemplate.update(updateSQL);

    }

    public List<DotaHeroInfo> query() {
        return jdbcTemplate.query(Constants.QUERY_ALL_BASE, new DotaHeroInfoRowMapper());
    }
}
