package com.adebisi.multitenantDemo.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class ResolverImplementation implements RequestResolver<HttpServletRequest>{

    private String tenantId = "TENANT-ID";

    @Override
    public String getTenantId(HttpServletRequest object) {
        return object.getHeader(tenantId);
    }
}
