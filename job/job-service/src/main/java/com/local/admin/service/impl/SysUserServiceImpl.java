package com.local.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangdang.ddframe.job.executor.handler.JobProperties;
import com.local.admin.dao.mapper.SysUserMapper;
import com.local.admin.model.SysUserEntity;
import com.local.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public void moveSysUser() {
        List<SysUserEntity> list = list();
        System.out.println(JSON.toJSONString(list));
    }
}
