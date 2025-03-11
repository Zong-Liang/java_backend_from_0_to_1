package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.exception.BusinessException;
import com.tlias.mapper.ClazzMapper;
import com.tlias.mapper.StudentMapper;
import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PageResult;
import com.tlias.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    //条件分页查询
    @Override
    public PageResult<Clazz> pageRead(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        List<Clazz> clazzList = clazzMapper.listByPage(clazzQueryParam);

        Page<Clazz> clazzPage = (Page<Clazz>) clazzList;

        return new PageResult<>(clazzPage.getTotal(), clazzPage.getResult());
    }

    //新增班级
    @Override
    public void saveClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insertClazz(clazz);

    }

    //删除班级
    @Override
    public void deleteClazz(Integer id) {
        //查询班级下是否有学员
        Integer count = studentMapper.countByClazzId(id);
        if(count > 0){
            throw new BusinessException("班级下有学员, 不能直接删除~");
        }
        //2. 如果没有, 再删除班级信息
        clazzMapper.deleteById(id);

    }

    //根据id查询班级
    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getById(id);
    }

    //修改班级
    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);

    }

    //查询所有班级
    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }
}
