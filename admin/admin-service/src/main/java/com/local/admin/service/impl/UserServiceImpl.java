package com.local.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.local.admin.dao.mapper.SysUserMapper;
import com.local.admin.model.UserEntity;
import com.local.admin.service.UserService;
import org.springframework.stereotype.Service;

@Service("sysUserServiceImpl")
public class UserServiceImpl extends ServiceImpl<SysUserMapper, UserEntity> implements UserService {


}
