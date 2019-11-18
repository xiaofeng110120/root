package com.local;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.local.config.SpringUtil;
import com.local.job.MoveSysUserJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.local")
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
        //核心配置
        JobCoreConfiguration coreConfiguration = JobCoreConfiguration.newBuilder("TEST", "0/60 * * * * ?", 1).build();
        //type配置
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(coreConfiguration, MoveSysUserJob.class.getCanonicalName());

        //根配置
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).build();

        //注册中心
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("192.168.30.2:2181", "xxx"));
        regCenter.init();

        //任务启动
        new JobScheduler(regCenter, liteJobConfiguration).init();

    }
}