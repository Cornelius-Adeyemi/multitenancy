package com.adebisi.multitenantDemo.hibernate_tenant_resolver;

import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class ConnectProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {

   private final DataSource dataSource;

    @Override
    public Connection getAnyConnection() throws SQLException {
        return getConnection("PUBLIC");
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
       connection.close();
    }

    @Override
    public Connection getConnection(Object o) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setSchema((String) o);
        return connection;
    }

    @Override
    public void releaseConnection(Object o, Connection connection) throws SQLException {
        connection.setSchema("PUBLIC");
       connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public  boolean isUnwrappableAs(@UnknownKeyFor @NonNull @Initialized Class<@UnknownKeyFor @NonNull @Initialized ?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap( Class<T> aClass) {
        return null;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
          hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
    }
}
