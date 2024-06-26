package com.gcu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.OrdersBusinessServiceInterface;
import com.gcu.model.OrderModel;


@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    // test pipeline
    // uses dependency injection configuration found in the SpringConfig file
    // to choose which businessService will be utilized
    
    @Autowired
    private OrdersBusinessServiceInterface ordersService;

    @GetMapping("/")
    public List<OrderModel> showAllOrders(){
        return ordersService.getOrders();
    }

    @GetMapping("/id")
    public OrderModel getOne(@PathVariable(name="id") int id){
        return ordersService.getOne(id);
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){
        return ordersService.searchOrders(searchTerm);
    }

    @PostMapping("/")
    public OrderModel addOrder(@RequestBody OrderModel addOrder){
        ordersService.addOne(addOrder);
        return addOrder;
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable(name="id") int id){
        return ordersService.deleteOne(id);
    }

    @PutMapping("/")
    public OrderModel updateOrder(@RequestBody OrderModel updateOrder){
        return ordersService.updateOne(updateOrder.getId(), updateOrder);
    }
    
}
