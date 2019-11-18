package com.local.admin.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * mybatisPlus相关配置
 * </p>
 *
 * @author xiaofeng
 * @since 2019-04-17
 */
@Configuration
@MapperScan("com.local.admin.dao.mapper")//这个注解，作用相当于下面的@Bean MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    /**
//     * 相当于顶部的：
//     * {@code @MapperScan("com.local.admin.mapper")}
//     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
//     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setBasePackage("com.local.admin.mapper");
//        return scannerConfigurer;
//    }

    /**
     * 获取序列号 配合@KeySequence注解，@TableId(value = "id", type = IdType.INPUT)注解一起使用
     */
    @Bean
    public H2KeyGenerator getH2KeyGenerator() {
        return new H2KeyGenerator();
    }

    @Bean
    @Profile(value = {"default", "dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        //启用性能分析插件
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(300L);
        return performanceInterceptor;
    }

//    /**
//     * 会打印出原sql和转换后sql
//     */
//    @Bean
//    @Profile(value = {"default", "dev", "test"})
//    public SqlExplainInterceptor sqlExplainInterceptor(){
//        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        sqlParserList.add(new BlockAttackSqlParser());
//        sqlExplainInterceptor.setSqlParserList(sqlParserList);
//        return sqlExplainInterceptor;
//    }
}