package com.adebisi.multitenantDemo.config;



public class ContextHolder {

    private static final ThreadLocal<String> tenantIdentifier = new ThreadLocal<>();


    public static void setContext(String tenantId){
        tenantIdentifier.set(tenantId);
    }

    public static String getContext(){

        return tenantIdentifier.get();
    }


   public static  void clearContext(){
        tenantIdentifier.remove();

   }
}
