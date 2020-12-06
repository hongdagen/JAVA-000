package com.hyhy.dbproxy_homework;


import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 JDBC 原生接口，实现数据库的增删改查操作
 */
@Component
public class JDBCOri {

    private static Connection conn = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Integer insert(TOrderEntity info) {
        if (conn != null) {
            String insertSQL = String.format(Constants.INSERT_BASE,info.getId(), info.getUserId(),info.getAmount(),sdf.format(info.getOrderGeneratedTime()),info.getStatus(),info.getProductIds());
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

    public Integer update(Integer id, TOrderEntity newInfo) {
        if (conn != null) {
            String updateSQL = String.format(Constants.UPDATE_BASE,
                    newInfo.getUserId(),
                    newInfo.getAmount(),
                    sdf.format(newInfo.getOrderGeneratedTime()),
                    newInfo.getStatus(),
                    newInfo.getProductIds(),
                    newInfo.getId()
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

    public List<TOrderEntity> query() {
        List<TOrderEntity> result = new ArrayList<>();
        if (conn != null) {
            Statement sm = null;
            ResultSet rs = null;
            try {
                sm = conn.createStatement();
                rs = sm.executeQuery(Constants.QUERY_ALL_BASE);
                while (rs.next()) {
                    TOrderEntity info = new TOrderEntity(
                            rs.getLong("id"),
                            rs.getLong("user_id"),
                            rs.getLong("amount"),
                            rs.getDate("order_generated_time"),
                            rs.getInt("status"),
                            rs.getLong("product_ids")
                    );
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
