package com.company.coffeeshop.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
@Data
@Slf4j
public class GcloudProperties {

    private String bucketName;
    private String bucketFolder;
}
