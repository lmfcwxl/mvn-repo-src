package com.travel.ssm.dao;

import com.travel.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //根据Id查询产品
    @Select("select * from product where id = #{id}")
    public List<Product> findById(String id);

    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll();

    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
