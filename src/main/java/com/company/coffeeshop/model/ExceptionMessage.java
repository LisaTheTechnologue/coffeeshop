package com.company.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("device_name")
    private String deviceName;

    @JsonProperty("metric_type")
    @Builder.Default
    private String metricType = "";
}
