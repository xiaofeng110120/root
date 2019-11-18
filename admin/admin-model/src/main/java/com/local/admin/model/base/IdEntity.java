package com.local.admin.model.base;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class IdEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id")
    private String id;
}
