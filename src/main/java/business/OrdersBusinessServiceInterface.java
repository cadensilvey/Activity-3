package business;

import java.util.List;
import com.gcu.model.OrderModel;

// this is an interface that we are going to implement into our code later on
public interface OrdersBusinessServiceInterface {
    
    public void test();
    public List<OrderModel> getOrders();
    public OrderModel getOne(int id);
    public List<OrderModel> searchOrders(String searchTerm);
    public int addOne(OrderModel newOrder);
    public boolean deleteOne(long l);
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
    public void init();
    public void destroy();
}
