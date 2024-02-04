package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.gcu.model.OrderModel;


@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface {
    
    private List<OrderModel> orders = new ArrayList<OrderModel>();

    public OrdersFakeDAO(){
        orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(0L, "001", "Heli Sking in the Alps", 500.0f, 1));
        orders.add(new OrderModel(1L, "002", "Rock climb in Red Rocks", 50.0f, 5));
        orders.add(new OrderModel(2L, "003", "Hike in Olympic National Park", 25.0f, 10));
        orders.add(new OrderModel(3L, "004", "Walk through the Subway in Zion", 100.0f, 11));
        orders.add(new OrderModel(4L, "005", "Skydive in Arizona", 600.0f, 1));
        orders.add(new OrderModel(5L, "006", "Surf in Chelan", 30.0f, 25));
        orders.add(new OrderModel(6L, "007", "Attend a Wedding", 1.0f, 10));
        orders.add(new OrderModel(7L, "008", "Hike 25 Miles of PCT", 100.0f, 2));
        orders.add(new OrderModel(8L, "009", "Climb the Fridge v8 in Leavenworth", 0.0f, 1));
        orders.add(new OrderModel(9L, "010", "Pass Classes", 250000.0f, 6));
    }

    @Override
    public OrderModel getById(int id) {
        return orders.stream()
        .filter(order -> order.getId() == id)
        .findFirst()
        .get();
    }

    @Override
    public List<OrderModel> getOrders() {
        // TODO Auto-generated method stub
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
         // if you like to use streams use this example.
         List<OrderModel> foundItems = orders
         .stream()
         .filter(order -> order.getProductName().toLowerCase()
                 .contains(searchTerm.toString().toLowerCase()))
             .collect(Collectors.toList());

     /*
      * this code uses a standard for loop to find the correct order in the list
      List<OrderModel> foundItems = new ArrayList<OrderModel>();
      for (int i = 0; i < orders.size(); i++){
         if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())){
             foundItems.add(orders.get(i));
         }
      }
      */

     //  for testing, print out a status message to the server console
     System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
     return foundItems;
    }

    @Override
    public int addOne(OrderModel newOrder) {
        boolean success = orders.add(newOrder);

        // for testing print a status message to the server console 
        System.out.println("I added one item. New there are " + orders.size() + " items in the List");
        if(success){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean deleteOne(long id) {
        orders.removeIf(order -> order.getId() == id);

        // for testing print a status message to the server console 
        System.out.println("I added one item. New there are " + orders.size() + " items in the List");     

        return true;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        // find the matching order
        orders.stream().forEach(order -> {
            if (order.getId() == idToUpdate){
                order.setOrderNo(updateOrder.getOrderNo());
                order.setPrice(updateOrder.getPrice());
                order.setProductName(updateOrder.getProductName());
                order.setQuantity(updateOrder.getQuantity());
                System.out.println("Updated order "+ updateOrder);
            }
        });

    // for testing print a status message to the server console
    System.out.println("You asked me to update order numer " + idToUpdate + ". The updated order is " + updateOrder.toString());

    // if no order matches the given idToUpdate, do nothing and return null
    System.out.println("I tried to find the order number " + idToUpdate + " but couldn't find the one that matches");
        
        return null;
    }    
}
