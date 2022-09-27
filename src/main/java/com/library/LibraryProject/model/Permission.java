package com.library.LibraryProject.model;

public enum Permission {
    READ("users:read"),
    WRITE("users:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
