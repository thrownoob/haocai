package com.haocai.web.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.haocai.web.mod.Cat;
import com.haocai.web.mod.Equipment;
import com.haocai.web.mod.Haocai;
import com.haocai.web.mod.Jilu;
import com.haocai.web.mod.JiluHaocai;
import com.haocai.web.mod.Tna;
import com.haocai.web.mod.User;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface MyBatisBaseDao<Model, PK extends Serializable> {
    int deleteByPrimaryKey(PK id);

    int insert(HashMap<String, Object> map);

    int insertSelective(HashMap<String, Object> map);

    Model selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(HashMap<String, Object> map);

    int updateByPrimaryKey(Model record);
    
    List<Cat> getalcr();
    //条件查询种类
    List<Tna> gettna(Tna ta);
    //查询种类名称
    List<Tna> getnames();
    
    List<Cat> getcatdn(Cat cat);
    
    List<Equipment> getequ();
    
    List<Equipment> getdny(Equipment que);
    
    List<Jilu> getjilu(String a);//根据EID查纪录
    
    User loginCheck(User user);
    
    List<JiluHaocai> getjiluhaocai(JiluHaocai jiluhaocai);//动态查询耗材记录
    
    int getcount(JiluHaocai jiluHaocai);
    
    int updatebynamefornumberup(HashMap<String, Object> map);//出入库数量变更
    
    int updatebynamefornumberdown(HashMap<String, Object> map);//出库数量变更
    
    String selectbynamefornumber(String name);//查询单个余量
    
    List<Haocai> getname();
    
    List<Haocai> getallhaocai(String name);
    
    int  upgcname(String name);
    
    
}