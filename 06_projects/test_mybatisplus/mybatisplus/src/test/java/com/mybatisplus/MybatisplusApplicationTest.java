package com.mybatisplus;

import com.mybatisplus.mapper.DeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTest {

    @Autowired
    DeptMapper deptMapper;

    @Test
    void contextLoads() {
        System.out.println(deptMapper.selectById(1));
    }
}
