package com.practice.ssm.service;

import com.practice.ssm.daomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(String id) throws Exception;

    void addRoleToUser(String userId, String[] ids);
}
