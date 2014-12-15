package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2014/12/15.
 */

@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sql = " INSERT INTO t_login_log(user_id, ip, login_datetime) " +
                " VALUE(?, ?, ?) ";
        jdbcTemplate.update(sql, new Object[] {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
    }
}
