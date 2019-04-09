package com.haocai.web.dao;

import com.haocai.web.mod.User;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, User> {
}