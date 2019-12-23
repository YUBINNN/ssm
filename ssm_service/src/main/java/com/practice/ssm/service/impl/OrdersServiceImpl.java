package com.practice.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.practice.ssm.dao.OrdersDao;
import com.practice.ssm.dao.ProductDao;
import com.practice.ssm.daomain.Orders;
import com.practice.ssm.daomain.Product;
import com.practice.ssm.service.OrdersService;
import com.practice.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {

        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {

        PageHelper.startPage(page,pageSize);
        return ordersDao.findAllByPage();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
