package com.local.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.local.admin.dao.mapper.SysUserMapper;
import com.local.admin.model.UserEntity;
import com.local.admin.service.UserService;
import com.local.admin.service.util.DBContext;
import com.local.admin.service.vo.sysuser.AddSysUserReqVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service("sysUserServiceImpl")
public class UserServiceImpl extends ServiceImpl<SysUserMapper, UserEntity> implements UserService {

    @DS("slave")
    @Transactional
    @HystrixCommand(
            commandProperties = { //用来传入自定义控制参数
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000") //调用超时时间超过该值会被hystrix中断
            }
    )//使用该注解导致@DS("slave")无效，数据会被写到主库。可使用此包代码com.local.admin.service.hystrix，将ThreadLocal中的值向Hystrix的线程中传递
    @Override
    public void addSysUser(AddSysUserReqVo addSysUserReqVo) throws InterruptedException {
//        System.out.println("ssssss:" + DynamicDataSourceContextHolder.peek());//使用此包下代码后com.local.admin.service.hystrix，可获取该值
        Random random = new Random();
        if(random.nextInt(4) == 3){
            Thread.sleep(5000L);
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setAccountNo(addSysUserReqVo.getAccountNo());
        userEntity.setPassword("password");
        userEntity.setName(addSysUserReqVo.getName());
        userEntity.setPhone(addSysUserReqVo.getPhone());
        userEntity.setEmail(addSysUserReqVo.getEmail());
        userEntity.setRemark(addSysUserReqVo.getRemark());
        userEntity.setStatus("1");
        userEntity.setCreateUser("1");
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateUser("1");
        userEntity.setUpdateTime(new Date());
        save(userEntity);
//        baseMapper.saveUser(userEntity);


    }

}
