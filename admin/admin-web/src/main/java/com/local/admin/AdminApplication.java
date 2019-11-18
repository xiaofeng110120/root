package com.local.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.lang.reflect.InvocationHandler;

/**
 * 提供一个/refresh端点 访问该端点，会强制spring boot应用重新读取应用程序配置，注解只会重新加载应用程序自定义spring属性，
 * 如spring data数据库配置等不会重新加载， 1.在docker等容器环境中建议重启服务，2.可查询注册中心服务中所有服务实例，
 * 并挨个调用这些服务的所有/refush端点，3.spring cloud bus使用消息机制 //todo 调用refresh端点后PropConfig类中属性值未发生变化
 */
@RefreshScope
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 120)
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients(basePackages = "com.local.admin.feign")
@EnableCircuitBreaker  //告诉将要为服务使用Hystrix
//@EnableHystrix
//@EnableHystrixDashboard
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
