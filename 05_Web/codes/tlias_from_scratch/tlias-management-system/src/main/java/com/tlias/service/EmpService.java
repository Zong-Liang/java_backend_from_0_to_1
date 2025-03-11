package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.LoginInfo;
import com.tlias.pojo.PageResult;

import java.util.List;

public interface EmpService{

    PageResult<Emp> pageRead(EmpQueryParam empQueryParam);

    void saveEmp(Emp emp);

    void deleteEmp(List<Integer> ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    List<Emp> listAll();

    LoginInfo login(Emp emp);
}
