package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import business.AnotherOrdersBusinessService;
import business.OrdersBusinessService;
// import business.OrdersBusinessService;
import business.OrdersBusinessServiceInterface;
import business.SecurityServiceInterface;
import business.ThreeValidLogins;

@Configuration
public class SpringConfig {

    @Bean(name="ordersBusinessService")
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new AnotherOrdersBusinessService();
    }

    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService(){
        return new ThreeValidLogins();
    }
}
