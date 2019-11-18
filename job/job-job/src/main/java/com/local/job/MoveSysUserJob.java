package com.local.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.local.admin.service.SysUserService;
import com.local.config.MyJobProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveSysUserJob implements SimpleJob {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MyJobProperties myJobProperties;

    @Override
    public void execute(ShardingContext shardingContext) {
        String test = myJobProperties.getTest();
        System.out.println("test:" + test);
        int shardingItem = shardingContext.getShardingItem();

        switch (shardingItem) {
            case 1:
                sysUserService.moveSysUser();
                break;
            case 2:
                sysUserService.moveSysUser();
                break;
        }


    }


}
