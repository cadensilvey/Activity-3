package business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    private List<OrderModel> orders;

    @Override
    public void test() {
        System.out.println("The test method of the OrdersBusinessService appears to be working if you can see this.");        
    }

    @Override
    public void init() {
        System.out.println("init method of OrderBusinessService was just called");
        orders = new ArrayList<OrderModel>();        
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of OrderBusinessService was just called in.");
        
    }    

    @Override
    public List<OrderModel> getOrders() {
        orders.clear();
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
        return orders;
    } 
    
}
