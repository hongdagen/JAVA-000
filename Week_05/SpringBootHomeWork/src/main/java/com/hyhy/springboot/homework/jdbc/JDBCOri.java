package com.hyhy.springboot.homework.jdbc;

import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 JDBC 原生接口，实现数据库的增删改查操作
 */
@Component
public class JDBCOri {

    private static Connection conn = null;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Integer insert(DotaHeroInfo info) {
        if (conn != null) {
            Integer isCarry = 0;
            if (info.getIsCarry()) {
                isCarry = 1;
            }
            String insertSQL = String.format(Constants.INSERT_BASE, info.getName(), info.getStrength(), info.getAgility(), info.getIntelligence(), isCarry);
            Statement sm = null;
            try {
                sm = conn.createStatement();
                return sm.executeUpdate(insertSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (sm != null) {
                    try {
                        sm.close();
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
        if (conn != null) {
            String deleteSQL = String.format(Constants.DELETE_BASE, id);
            Statement sm = null;
            try {
                sm = conn.createStatement();
                return sm.executeUpdate(deleteSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (sm != null) {
                    try {
                        sm.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public Integer update(Integer id, DotaHeroInfo newInfo) {
        if (conn != null) {
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
            Statement sm = null;
            try {
                sm = conn.createStatement();
                return sm.executeUpdate(updateSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (sm != null) {
                    try {
                        sm.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public List<DotaHeroInfo> query() {
        List<DotaHeroInfo> result = new ArrayList<>();
        if (conn != null) {
            Statement sm = null;
            ResultSet rs = null;
            try {
                sm = conn.createStatement();
                rs = sm.executeQuery(Constants.QUERY_ALL_BASE);
                while (rs.next()) {
                    DotaHeroInfo info = new DotaHeroInfo(
                            rs.getString("name"),
                            rs.getInt("strength"),
                            rs.getInt("agility"),
                            rs.getInt("intelligence")
                    );
                    int is_carry = rs.getInt("is_carry");
                    if (is_carry == 0) {
                        info.setIsCarry(false);
                    } else {
                        info.setIsCarry(true);
                    }
                    result.add(info);
                }
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (sm != null && rs != null) {
                    try {
                        rs.close();
                        sm.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
