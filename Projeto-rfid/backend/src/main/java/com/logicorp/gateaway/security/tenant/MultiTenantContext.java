package com.logicorp.security.tenant;

public class MultiTenantContext {

    private static final ThreadLocal<String> TENANT = new ThreadLocal<>();

    public static void setTenant(String tenant) {
        TENANT.set(tenant);
    }

    public static String getTenant() {
        return TENANT.get();
    }

    public static void clear() {
        TENANT.remove();
    }
}