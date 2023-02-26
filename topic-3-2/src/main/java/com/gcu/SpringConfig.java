package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import business.AnotherOrdersBusinessService;
// import business.OrdersBusinessService;
import business.OrdersBusinessServiceInterface;
import business.SecurityServiceInterface;
import business.ThreeValidLogins;

@Configuration
public class SpringConfig {

    @Bean(name="ordersBusinessService", initMethod="init", destroyMethod = "destroy")
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new AnotherOrdersBusinessService();
    }

    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService(){
        return new ThreeValidLogins();
    }
}
