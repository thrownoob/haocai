package com.haocai.web.dao;

import com.haocai.web.mod.Haocai;
import org.springframework.stereotype.Repository;

/**
 * HaocaiDAO继承基类
 */
@Repository
public interface HaocaiDAO extends MyBatisBaseDao<Haocai, String> {
}