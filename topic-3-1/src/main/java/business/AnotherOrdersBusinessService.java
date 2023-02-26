package business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test() {
        System.out.println("The test method of ANOTHER OrderBusinessService is working if you can read this text.");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(10L, "AAA", "Chicken Sandwhich", 4.50f, 1));
        orders.add(new OrderModel(11L, "AAB", "Fries", 1.50f, 4));
        orders.add(new OrderModel(12L, "AAC", "Chicken Nuggets", 3.50f, 2));
        orders.add(new OrderModel(13L, "AAD", "Frosted Lemonade", 1.20f, 10));
        orders.add(new OrderModel(14L, "AAE", "Cookie", 0.99f, 100));

        return orders;
    }
    
}
