package com.practice.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.practice.ssm.daomain.Orders;
import com.practice.ssm.daomain.Product;
import com.practice.ssm.service.OrdersService;
import com.practice.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        System.out.println(ordersList);
//        modelAndView.addObject("ordersList",ordersList);
//        modelAndView.setViewName("orders-list");
//        System.out.println(ordersList);
//        return modelAndView;
//    }


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")
    Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer
    pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
