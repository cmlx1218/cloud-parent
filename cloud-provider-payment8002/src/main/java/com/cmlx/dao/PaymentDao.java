package com.cmlx.dao;

import com.cmlx.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/22 15:34
 */
@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);


}
