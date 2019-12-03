package com.local.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.local.admin.model.UserEntity;
import com.local.admin.vo.sysuser.AddSysUserReqVo;

public interface UserService extends IService<UserEntity> {
    /**
     * 新增用户
     *
     * @param addSysUserReqVo 新增用户入参
     */
    void addSysUser(AddSysUserReqVo addSysUserReqVo) throws InterruptedException;


}
