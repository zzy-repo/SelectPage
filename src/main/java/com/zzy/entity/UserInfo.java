package com.zzy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author zzy
 * @since 2024-09-06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 出生年月
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 性别 0:女 1:男
     */
    @TableField("sex")
    private Boolean sex;

    /**
     * 职位0:程序员 1:测试  2:产品经理
     */
    @TableField("position")
    private Boolean position;

    /**
     * 角色 0:普通用户 1:组长 2:经理 3:管理员 可多选
     */
    @TableField("roles")
    private String roles;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
