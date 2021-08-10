package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BsaeDao implements UserDao {
    @Override
    public User queryUserByUsername(String name) {
        String sql = "SELECT `id`,`name`,`pwd`,`email` FROM t_user WHERE `name`= ?";
        return queryForOne(User.class,sql,name);

    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`name`,`pwd`,`email` from t_user where `name` = ? and `pwd` = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`name`,`pwd`,`email`) VALUE (?,?,?)";
        return update(sql,user.getName(),user.getPwd(),user.getEmail());
    }
}
