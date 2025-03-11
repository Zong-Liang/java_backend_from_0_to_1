package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.EmpExprMapper;
import com.tlias.mapper.EmpLogMapper;
import com.tlias.pojo.*;
import com.tlias.service.EmpLogService;
import com.tlias.service.EmpService;
import com.tlias.mapper.EmpMapper;
import com.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> pageRead(EmpQueryParam empQueryParam) {
        //设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //执行查询
        List<Emp> empList = empMapper.listByPage(empQueryParam);

        //解析查询结果, 并封装
        Page<Emp> empPage = (Page<Emp>) empList;
        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }

    //推荐将事务注解 @Transactional 写在多次对数据库进行增删改的业务方法上
    //事务管理 - 默认出现运行时异常 RuntimeException 才会回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveEmp(Emp emp) {
        try {
            //保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insertEmp(emp);

            //保存员工工作经历信息
            List<EmpExpr> empExprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(empExprList)) {
                //遍历集合, 为empId赋值
                empExprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertExpr(empExprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工:" + emp);
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteEmp(List<Integer> ids) {
        //批量删除员工基本信息
        empMapper.deleteByIds(ids);
        //批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);

    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateEmp(Emp emp) {
        //根据ID修改员工的基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmpById(emp);

        //根据ID删除员工原有的工作经历信息
        empExprMapper.deleteByEmpIds(List.of(emp.getId()));
        //添加员工新的工作经历信息
        List<EmpExpr> empExprList = emp.getExprList();
        if (!empExprList.isEmpty()){
            empExprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertExpr(empExprList);
        }

    }

    @Override
    public List<Emp> listAll() {
        return empMapper.listAll();
    }

    @Override
    public LoginInfo login(Emp emp) {
        //1. 调用mapper接口, 根据用户名和密码查询员工信息
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        //2. 判断: 判断是否存在这个员工, 如果存在, 组装登录成功信息
        if(e != null){
            log.info("登录成功, 员工信息: {}", e);
            //生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateToken(claims);

            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }

        //3. 不存在, 返回null
        return null;
    }
}
