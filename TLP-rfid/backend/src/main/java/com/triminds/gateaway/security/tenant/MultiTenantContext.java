package com.triminds.gateaway.security.tenant;

public class MultiTenantContext {

    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_ROLE = new ThreadLocal<>();

    // -------------------------
    // TENANT
    // -------------------------
    public static void setTenantId(String tenantId) {
        CURRENT_TENANT.set(tenantId);
    }

    public static String getTenantId() {
        return CURRENT_TENANT.get();
    }

    // -------------------------
    // USER
    // -------------------------
    public static void setUserEmail(String email) {
        CURRENT_USER.set(email);
    }

    public static String getUserEmail() {
        return CURRENT_USER.get();
    }

    // -------------------------
    // ROLE
    // -------------------------
    public static void setUserRole(String role) {
        CURRENT_ROLE.set(role);
    }

    public static String getUserRole() {
        return CURRENT_ROLE.get();
    }

    // -------------------------
    // CLEAR (IMPORTANTE)
    // -------------------------
    public static void clear() {
        CURRENT_TENANT.remove();
        CURRENT_USER.remove();
        CURRENT_ROLE.remove();
    }
}