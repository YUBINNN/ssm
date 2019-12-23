package com.practice.ssm.service;

import com.practice.ssm.daomain.SysLog;

import java.util.List;

public interface SysLogService {

    List<SysLog> findAll() throws Exception;

    void save(SysLog sysLog);

}
