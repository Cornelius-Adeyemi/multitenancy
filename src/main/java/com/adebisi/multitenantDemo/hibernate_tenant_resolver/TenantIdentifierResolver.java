package com.adebisi.multitenantDemo.hibernate_tenant_resolver;

import com.adebisi.multitenantDemo.config.ContextHolder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * this is to get tenant_id
 *
 */
@Component
public class TenantIdentifierResolver  implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    @Override
    public Object resolveCurrentTenantIdentifier() {
        return Objects.requireNonNullElse(ContextHolder.getContext(),"PUBLIC");
    }

    @Override
    public boolean validateExistingCurrentSessions() {

        return false;
    }


    @Override
    public void customize(Map<String, Object> hibernateProperties) {
     hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
