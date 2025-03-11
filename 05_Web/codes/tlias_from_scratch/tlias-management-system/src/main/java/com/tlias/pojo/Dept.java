package com.tlias.pojo;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 * @TableName dept
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    /**
     * ID, 主键
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
