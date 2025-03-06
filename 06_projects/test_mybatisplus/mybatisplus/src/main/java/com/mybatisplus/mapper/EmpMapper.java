package com.mybatisplus.mapper;

import com.mybatisplus.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Zong Liang
* @description 针对表【emp(员工表)】的数据库操作Mapper
* @createDate 2025-03-06 22:05:21
* @Entity com.mybatisplus.pojo.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}
