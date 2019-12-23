package com.practice.ssm.service;

import com.practice.ssm.daomain.Orders;
import com.practice.ssm.daomain.Product;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll() throws Exception;

    List<Orders> findAllByPage(int page,int pageSize) throws Exception;

    Orders findById(String id);
}
