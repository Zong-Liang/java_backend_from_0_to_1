package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

//    //原始分页查询实现
//    //查询总记录数
//    @Select("select count(*) from emp e left join dept d on d.id = e.dept_id")
//    public Long count();
//
//    //分页查询
//    @Select("select e.*, d.name deptName " +
//            "from emp e left join dept d " +
//            "on d.id = e.dept_id " +
//            "order by e.update_time desc " +
//            "limit #{start},#{pageSize};")
//    public List<Emp> list(Integer start, Integer pageSize);

    //使用pagehelper插件
//    @Select("select e.*, d.name deptName " +
//            "from emp e left join dept d " +
//            "on d.id = e.dept_id " +
//            "order by e.update_time desc")
//    public List<Emp> list();

    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id") //获取到生成的主键
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "values(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);
}
