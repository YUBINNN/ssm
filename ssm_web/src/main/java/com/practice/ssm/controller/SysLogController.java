package com.practice.ssm.controller;

import com.practice.ssm.daomain.SysLog;
import com.practice.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/sysLog")
@Controller
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
       List<SysLog> sysLogList = sysLogService.findAll();
       ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogList", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

}
