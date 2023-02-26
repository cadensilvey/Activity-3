package com.gcu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.OrderModel;

import business.OrdersBusinessServiceInterface;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    // this will get one of the two OrdersService we have defined
    // the SpringConfig.java file determines whether the app will return 
    // either junk food (AnotherOrdersBusinessService) or fun activities 

    @Autowired
    private OrdersBusinessServiceInterface ordersService;

    @GetMapping("/")
    public String showAllOrders(Model model){
        
        // get some orders - either junk food or adventure 
        List<OrderModel> orders = ordersService.getOrders();

        // display the orders view
        model.addAttribute("title", "This is what you ordered");
        model.addAttribute("orders", orders);
        return "orders";
        
    }
    
}
