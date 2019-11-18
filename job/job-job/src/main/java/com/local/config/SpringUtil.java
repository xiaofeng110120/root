package com.local.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author xiaofeng
 * @since 2019-05-09
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBeanByName(String beanName){
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

}
