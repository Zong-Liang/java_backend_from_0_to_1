package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.pojo.Dept;
import com.mybatisplus.service.DeptService;
import com.mybatisplus.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author Zong Liang
* @description 针对表【dept(部门表)】的数据库操作Service实现
* @createDate 2025-03-06 22:05:21
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




