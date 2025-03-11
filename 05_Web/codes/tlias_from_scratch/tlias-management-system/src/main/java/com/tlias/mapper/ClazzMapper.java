package com.tlias.mapper;

import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    //条件分页查询
    List<Clazz> listByPage(ClazzQueryParam clazzQueryParam);

    //新增班级
    @Insert("insert into clazz VALUES (null,#{name},#{room},#{beginDate},#{endDate},#{masterId}, #{subject},#{createTime},#{updateTime})")
    void insertClazz(Clazz clazz);

    //删除班级
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    //根据id查询班级
    @Select("select * from clazz where  id = #{id}")
    Clazz getById(Integer id);

    //修改班级
    void updateById(Clazz clazz);

    //查询所有班级
    @Select("select * from clazz")
    List<Clazz> listAll();

}
