package com.tlias.mapper;

import com.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertExpr(List<EmpExpr> empExprList);

    void deleteByEmpIds(List<Integer> empIds);
}
