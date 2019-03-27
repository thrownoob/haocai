package com.haocai.web.dao;

import com.haocai.web.mod.Cat;
import org.springframework.stereotype.Repository;

/**
 * CatDAO继承基类
 */
@Repository
public interface CatDAO extends MyBatisBaseDao<Cat, String> {
}