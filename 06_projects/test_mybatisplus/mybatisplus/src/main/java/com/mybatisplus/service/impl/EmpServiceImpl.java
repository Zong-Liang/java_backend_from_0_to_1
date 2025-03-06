package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.pojo.Emp;
import com.mybatisplus.service.EmpService;
import com.mybatisplus.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author Zong Liang
* @description 针对表【emp(员工表)】的数据库操作Service实现
* @createDate 2025-03-06 22:05:21
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




