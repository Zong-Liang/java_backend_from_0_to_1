package com.tlias.pojo;


import java.time.LocalDate;
import lombok.Data;

/**
 * 工作经历
 * @TableName emp_expr
 */
@Data
public class EmpExpr {
    /**
     * ID, 主键
     */
    private Integer id;

    /**
     * 员工ID
     */
    private Integer empId;

    /**
     * 开始时间
     */
    private LocalDate begin;

    /**
     * 结束时间
     */
    private LocalDate end;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 职位
     */
    private String job;
}
