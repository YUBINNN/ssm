package com.practice.ssm.service.impl;

import com.practice.ssm.dao.PermissionDao;
import com.practice.ssm.daomain.Permission;
import com.practice.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return permissionDao.findOtherPermission(roleId);
    }

    @Override
    public List<Permission> findByRoleId(String roleId) {
        return permissionDao.findByRoleId(roleId);
    }

    @Override
    public Permission findById(String permissionId) {
        return permissionDao.findById(permissionId);
    }

    @Override
    public void deletePermission(String permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
