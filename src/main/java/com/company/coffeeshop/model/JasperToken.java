package com.company.coffeeshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JasperToken {

    private String username;
    private String organization;
    private String role;
}
