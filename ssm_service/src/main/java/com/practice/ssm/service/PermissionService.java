package com.practice.ssm.service;

import com.practice.ssm.daomain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermission(String roleId);

    List<Permission> findByRoleId(String roleId);

    Permission findById(String permissionId);

    void deletePermission(String permissionId);
}
