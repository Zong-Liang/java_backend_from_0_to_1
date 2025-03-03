package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//可以将方法中相同的请求路径提取到类上
@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {
//    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


    //查询全部部门数据
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){
//        System.out.println("查询全部部门数据：");
        log.info("查询全部部门数据：");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //根据ID删除部门数据
    @DeleteMapping
    //前端传递的请求参数名与服务端方法形参名一致时，可以省略@RequestParam注解
    public Result delete(Integer id){
//        System.out.println("根据ID删除部门数据：" + id);
        log.info("根据ID删除部门数据：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    //添加部门数据
    @PostMapping
    public Result add(@RequestBody Dept dept){
//        System.out.println("添加部门数据：" + dept);
        log.info("添加部门数据：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据ID查询部门数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
//        System.out.println("根据ID查询部门：" + id);
        log.info("根据ID查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success();
    }

    //修改部门数据
    @PutMapping
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改部门数据：" + dept);
        log.info("修改部门数据：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
