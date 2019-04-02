package com.haocai.web.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.haocai.web.mod.Cat;
import com.haocai.web.mod.Equipment;
import com.haocai.web.mod.Jilu;
import com.haocai.web.mod.Tna;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface MyBatisBaseDao<Model, PK extends Serializable> {
    int deleteByPrimaryKey(PK id);

    int insert(HashMap<String, Object> map);

    int insertSelective(Model record);

    Model selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(HashMap<String, Object> map);

    int updateByPrimaryKey(Model record);
    
    List<Cat> getalcr();
    
    List<Tna> gettna();
    
    List<Equipment> getequ();
    
    List<Equipment> getdny(Equipment que);
    
    List<Jilu> getjilu(String a);//根据EID查纪录
}