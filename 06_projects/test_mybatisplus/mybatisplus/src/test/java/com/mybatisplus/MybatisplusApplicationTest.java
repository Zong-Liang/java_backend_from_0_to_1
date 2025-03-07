package com.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.mapper.DeptMapper;
import com.mybatisplus.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTest {

    @Autowired
    DeptMapper deptMapper;


    @Test
    void test1() {
        deptMapper.selectById(1);
    }
    
    @Test
    void test2() {
        System.out.println("分页查询");
        Page<Dept> page = new Page<>(1, 2); // 创建分页对象
        deptMapper.selectPage(page, null);// 执行分页查询
    }
    }
