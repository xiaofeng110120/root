package com.local.admin.vo.base;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@ApiModel(value = "")
public class IdReqVo implements Serializable {

    private String id;

}
