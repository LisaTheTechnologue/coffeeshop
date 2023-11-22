package com.company.coffeeshop.properties;

import com.company.coffeeshop.model.JasperToken;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cs.ui.jasper")
@Data
public class JasperProperties {

    private String jwtSecret;
    private String url;
    private String organization;
    private String roleCodeList;
    private String roleDefault;
    private JasperToken tokenFormat = JasperToken.builder().build();
}
