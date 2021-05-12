package com.travel.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.travel.ssm.dao.IOrdersDao;
import com.travel.ssm.domain.Orders;
import com.travel.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        //参数为开始页数和每页显示数量
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception{
        return ordersDao.findById(ordersId);
    }
}
