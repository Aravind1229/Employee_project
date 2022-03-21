package com.rest.empdata.security;

import static com.rest.empdata.security.ApplicationUserPermission.*;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
ADMIN(Sets.newHashSet(EMPLOYEE_READ,EMPLOYEE_WRITE));


private final Set<ApplicationUserPermission> permissions;

private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
	this.permissions = permissions;
}

public Set<ApplicationUserPermission> getPermissions() {
	return permissions;
}

}
