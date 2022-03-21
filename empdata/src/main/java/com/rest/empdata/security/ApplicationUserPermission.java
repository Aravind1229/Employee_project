package com.rest.empdata.security;

public enum ApplicationUserPermission {
EMPLOYEE_READ("employee:read"),
EMPLOYEE_WRITE("employee:write");

private final String permission;
private ApplicationUserPermission(String permission) {
this.permission = permission;
}
	public String getPermission() {
		return permission;
	}
}
