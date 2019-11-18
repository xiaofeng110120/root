//package com.local.admin.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "markDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mark")
//    public DataSource markDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "testDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "dynamicDataSource")
//    public DynamicDataSource dataSource(@Qualifier("markDataSource") DataSource markDataSource,@Qualifier("testDataSource") DataSource testDataSource) {
//        Map<Object, Object> targetDataSource = new HashMap<>();
//        targetDataSource.put("mark", markDataSource);
//        targetDataSource.put("test", testDataSource);
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(targetDataSource);
//        dataSource.setDefaultTargetDataSource(testDataSource);
//        return dataSource;
//    }
//
//    @Bean(name = "SqlSessionFactory")
//    public SqlSessionFactory test1SqlSessionFactory(DataSource dynamicDataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
//        return bean.getObject();
//    }
//}
