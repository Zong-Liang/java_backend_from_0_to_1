package com.tlias.controller;

import com.tlias.pojo.*;
import com.tlias.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    //条件分页查询
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询: {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.pageRead(clazzQueryParam);
        return Result.success(pageResult);
    }

    //新增班级
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增班级: {}", clazz);
        clazzService.saveClazz(clazz);
        return Result.success();
    }


    //删除班级
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级: {}", id);
        clazzService.deleteClazz(id);
        return Result.success();
    }


    //根据ID查询班级
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }

    //修改班级
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级: {}", clazz);
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    //查询所有班级
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级数据");
        List<Clazz> clazzList = clazzService.listAll();
        return Result.success(clazzList);
    }


}
