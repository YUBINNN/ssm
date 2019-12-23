package com.practice.ssm.service.impl;

import com.practice.ssm.dao.UserDao;
import com.practice.ssm.daomain.Role;
import com.practice.ssm.daomain.UserInfo;
import com.practice.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findByUsername(s);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authorityList = getAuthority(roles);

//        return new User(userInfo.getUsername(),"{noop}" + userInfo.getPassword(), userInfo.getStatus() != 0,
//                true,true,true,authorityList);
        return new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() != 0,
                true,true,true,authorityList);
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" +  role.getRoleName()));
        }
        return authorityList;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();

    }

    @Override
    public void save(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);

    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            userDao.addRole(userId, roleId);
        }
    }
}
