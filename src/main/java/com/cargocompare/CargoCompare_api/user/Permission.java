package com.cargocompare.CargoCompare_api.user;



public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete")

    ;

    private final String permission;

    // Constructor explícito
    Permission(String permission) {
        this.permission = permission;
    }

    // Getter explícito
    public String getPermission() {
        return permission;
    }
}