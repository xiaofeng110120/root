package com.local.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.local.admin.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@TableName("sys_user")
public class UserEntity extends BaseEntity {

    /**
     * 账号
     */
    private String accountNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String remark;
    /**
     * 有效状态[1:有效；2：无效]
     */
    private String status;


}
