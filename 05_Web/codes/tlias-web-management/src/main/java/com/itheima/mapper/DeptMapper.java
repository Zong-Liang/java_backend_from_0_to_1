package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    //查询全部部门数据
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    //根据部门id删除部门数据
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //添加部门数据
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    //根据部门id查询部门数据
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    //根据id修改部门数据
    @Select("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
