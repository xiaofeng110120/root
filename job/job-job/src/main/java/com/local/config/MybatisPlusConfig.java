package com.local.config;

import com.baomidou.mybatisplus.extension.incrementer.PostgreKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * mybatisPlus相关配置
 * </p>
 *
 * @author guodong
 * @since 2019-06-24
 */
@Configuration
@MapperScan("com.local.admin.dao.mapper*")//这个注解，作用相当于下面的@Bean MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 相当于顶部的：
     * {@code @MapperScan("com.niwodai.middleground.intelligenceinspection.mapper*")}
     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setBasePackage("com.niwodai.middleground.intelligenceinspection.mapper*");
//        return scannerConfigurer;
//    }

    /**
     * 获取序列号
     *
     * @return
     */
    @Bean
    public PostgreKeyGenerator getPostgreKeyGenerator() {
        return new PostgreKeyGenerator();
    }


}