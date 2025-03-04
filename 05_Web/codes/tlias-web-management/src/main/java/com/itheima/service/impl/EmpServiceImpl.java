package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


//    //原始分页查询实现
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//
//        //调用Mapper接口查询总记录数
//        Long total =  empMapper.count();
//        //调用Mapper接口分页查询
//        List<Emp> rows = empMapper.list((page - 1) * pageSize, pageSize);
//        //封装结果
//        return new PageResult<Emp>(total, rows);
//    }

//    //使用pagehelper插件
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//
//        //设置分页查询参数
//        PageHelper.startPage(page, pageSize);
//        //执行查询
//        List<Emp> rows = empMapper.list();
//        //解析查询结果并封装
//        Page<Emp> p = (Page<Emp>) rows;
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//    }


    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> rows = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) rows;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

}
