package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2014/12/15.
 */

@Repository
public class UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password){
        String sql = " SELECT count(*) FROM t_user " +
                " where user_name =? and password = ? ";
        return jdbcTemplate.queryForInt(sql, new Object[]{userName, password});
    }


    public User findUserByUserName(final String userName){
        final User user = new User();

        String sqlStr = " SELECT user_id, user_name " +
                " FROM t_user where user_name=? ";
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(resultSet.getNString(userName));
                    }
                });

        return user;
    }

    public void updateLoginInfo(User user){
        String sql = " UPDATE t_user SET last_visit=?, last_ip =? " +
                " WHERE user_id = ? ";
        jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(), user.getUserId()});
    }
}
