package com.company.coffeeshop.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cs.ui.exception")
@Data
public class KafkaProperties {

    @NestedConfigurationProperty
    private Message message = new Message();

    @NestedConfigurationProperty
    private Kafka kafka = new Kafka();

    @Data
    public static class Message {
        private String deviceId;
        private String deviceName;
        private String metricType;
    }

    @Data
    public static class Kafka {
        private String topic;
        private boolean enabled;
    }
}
