package com.company.coffeeshop.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "cs.ui.encryption")
public class EncryptionProperties {

    private String keyResourceName;

    public String getKeyResourceName() {
        return String.format("gcp-kms://%s",keyResourceName);
    }
}
