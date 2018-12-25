package com.barbertony.poker.bean;

import lombok.Data;

/**
 * 用户
 * @author xiongwu
 **/
@Data
public class User {
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 唯一主键
     */
    private String code;
    /**
     * 分数
     */
    private Integer score;

    /**
     * 用户状态
     */
    private Integer status;
}
