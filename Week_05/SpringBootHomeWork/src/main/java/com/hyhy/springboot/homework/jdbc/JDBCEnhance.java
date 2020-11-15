package com.hyhy.springboot.homework.jdbc;

import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
 */

@Component
public class JDBCEnhance {

    private static Connection conn = null;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Integer insertBulk(List<DotaHeroInfo> infos) {
        if (conn != null) {

            PreparedStatement ps = null;
            try {
                // 事务
                conn.setAutoCommit(false);
                for (int i = 0; i < infos.size(); i++) {
                    DotaHeroInfo info = infos.get(i);
                    Integer isCarry = 0;
                    if (info.getIsCarry()) {
                        isCarry = 1;
                    }
                    ps = conn.prepareStatement(Constants.INSERT_ENHANCE_BASE);
                    ps.setString(1, info.getName());
                    ps.setInt(2, info.getStrength());
                    ps.setInt(3, info.getAgility());
                    ps.setInt(4, info.getIntelligence());
                    ps.setInt(5, isCarry);
                    ps.addBatch();
                }
                int[] ints = ps.executeBatch();
                System.out.println("execute batch length:"+ints.length);

                conn.commit();
                //ps.clearBatch();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                    ps.clearBatch();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public Integer delete(Integer id) {
        return 0;
    }

    public Integer update(Integer id, DotaHeroInfo newInfo) {
        return 0;
    }

    public List<DotaHeroInfo> query() {
        return null;
    }
}
