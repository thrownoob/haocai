package com.haocai.web.dao;

import com.haocai.web.mod.Equipment;
import org.springframework.stereotype.Repository;

/**
 * EquipmentDAO继承基类
 */
@Repository
public interface EquipmentDAO extends MyBatisBaseDao<Equipment, String> {
}