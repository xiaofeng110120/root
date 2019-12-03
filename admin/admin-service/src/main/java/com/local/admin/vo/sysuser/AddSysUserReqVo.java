package com.local.admin.vo.sysuser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Setter
@Getter
@ToString
@ApiModel(value = "新增用户请求")
public class AddSysUserReqVo implements Serializable {

    @ApiModelProperty(value = "姓名", required = true)
    @NotEmpty(message = "name不可为空")
    private String name;

    @ApiModelProperty(value = "账号", required = true)
    @NotEmpty(message = "accountNo不可为空")
    private String accountNo;

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "phone不可为空")
    @Pattern(regexp = "^[1]{1}[0-9]{10}$")
    private String phone;

    @ApiModelProperty(value = "邮箱", required = true)
    @Email(regexp = ".*", message = "邮箱格式错误")
    @NotEmpty(message = "email不可为空")
    private String email;

    @ApiModelProperty(value = "备注")
    private String remark;


}
