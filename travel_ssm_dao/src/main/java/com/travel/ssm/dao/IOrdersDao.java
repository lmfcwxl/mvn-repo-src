package com.travel.ssm.dao;

import com.travel.ssm.domain.Member;
import com.travel.ssm.domain.Orders;
import com.travel.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.travel.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll();

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",
                    column = "productId",
                    javaType = Process.class,
                    one = @One(select = "com.travel.ssm.dao.IProductDao.findById")),
            @Result(property = "member",
                    column = "memberId",
                    javaType = Member.class,
                    one = @One(select = "com.travel.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",
                    column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.travel.ssm.dao.ITravellerDao.findById"))
    })

    Orders findById(String ordersId);
}
