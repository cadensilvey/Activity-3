package business;

import java.util.List;
import com.gcu.model.OrderModel;

// this is an interface that we are going to implement into our code later on
public interface OrdersBusinessServiceInterface {
    
    public void test();
    public List<OrderModel> getOrders();
    public void init();
    public void destroy();
}
