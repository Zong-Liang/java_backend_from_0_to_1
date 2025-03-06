package com.mybatisplus.mapper;

import com.mybatisplus.pojo.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Zong Liang
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2025-03-06 22:05:21
* @Entity com.mybatisplus.pojo.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
