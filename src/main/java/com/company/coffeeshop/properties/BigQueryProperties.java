package com.company.coffeeshop.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cs.ui.bquery")
@Data
public class BigQueryProperties {

    private boolean enabled;
    private String tableName;
}
