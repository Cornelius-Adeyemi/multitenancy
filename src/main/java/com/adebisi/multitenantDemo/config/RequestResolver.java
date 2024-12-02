package com.adebisi.multitenantDemo.config;

public interface RequestResolver<T> {


    String getTenantId(T object);

}
