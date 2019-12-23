package com.practice.ssm.service;

import com.practice.ssm.daomain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRole(String id);

    Role findById(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
