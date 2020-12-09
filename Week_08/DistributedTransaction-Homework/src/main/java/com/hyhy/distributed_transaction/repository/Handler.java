package com.hyhy.distributed_transaction.repository;

import com.hyhy.distributed_transaction.entity.TUser;
import com.hyhy.distributed_transaction.entity.TUserAddrs;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: hyhy
 * @Date: 2020/12/9 9:27
 */
@Component
public class Handler {

    private static final String INSERT_USER_SQL = "INSERT INTO `t_user` (`id`, `name`, `mobile`, `pwd_hash`, `email`, `reg_time`, `addrs_id`) VALUES (?,?,?,?,?,?,?);";
    private static final String INSERT_USER_ADDR_SQL = "INSERT INTO `t_user_addrs` (`id`, `user_id`, `addr`, `last_update_time`) VALUES (?,?,?,?);";



    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public long insertUser(Connection connection, TUser user) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL)) {
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getPwdHash());
            ps.setString(5, user.getEmail());
            ps.setDate(6, new Date(user.getRegTime().getTime()));
            ps.setLong(7, user.getAddrsId());
            ps.executeUpdate();
        }
        return user.getId();
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void insertUserAddrs(Connection connection, TUserAddrs addr, long userId) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_USER_ADDR_SQL)) {
            ps.setLong(1, addr.getId());
            ps.setLong(2,userId);
            ps.setString(3, addr.getAddr());
            ps.setDate(4, null);
            ps.executeUpdate();
        }
    }
}
