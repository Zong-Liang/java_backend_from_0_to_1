package com.tlias.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工日志表
 * @TableName emp_log
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLog {
    /**
     * ID, 主键
     */
    private Integer id;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 日志信息
     */
    private String info;
}
