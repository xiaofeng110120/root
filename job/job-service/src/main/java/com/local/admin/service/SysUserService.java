package com.local.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.local.admin.model.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 移动用户
     */
    void moveSysUser();
}
