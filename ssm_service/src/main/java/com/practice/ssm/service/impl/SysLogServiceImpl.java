package com.practice.ssm.service.impl;

import com.practice.ssm.dao.SysLogDao;
import com.practice.ssm.daomain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements com.practice.ssm.service.SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        try {
            sysLogDao.save(sysLog);
            System.out.println("保存日志");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
