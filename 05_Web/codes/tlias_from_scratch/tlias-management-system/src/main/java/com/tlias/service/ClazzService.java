package com.tlias.service;


import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PageResult;

import java.util.List;

public interface ClazzService{

    //条件分页查询
    PageResult<Clazz> pageRead(ClazzQueryParam clazzQueryParam);

    //新增班级
    void saveClazz(Clazz clazz);

    //删除班级
    void deleteClazz(Integer id);

    //根id查询班级
    Clazz getClazzById(Integer id);

    //修改班级
    void updateClazz(Clazz clazz);

    //查询所有班级
    List<Clazz> listAll();
}
