package com.local.admin.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.local.admin.model.UserEntity;

public interface SysUserMapper extends BaseMapper<UserEntity> {

    void saveUser(UserEntity userEntity);
}
