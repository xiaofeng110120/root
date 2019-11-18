package com.local.admin.service.constant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@Setter
@Getter
@ToString
public class PropConfig {

    @Value("${server.port}")
    private String port;


    @Value("${admin.personal.test}")
    private String test;







}
