package com.cmlx.service;

import com.cmlx.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/22 15:47
 */
public interface IPaymentService {

    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
