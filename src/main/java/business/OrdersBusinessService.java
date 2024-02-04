package business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    // uses dependency injection configured in teh SpringConfig file 
    // to determin which database (fakeDAO or mySQL, still to be created) will be used
    @Autowired
    OrdersDataAccessInterface ordersDAO;

    @Override
    public void test() {
        System.out.println("The test method of the OrdersBusinessService appears to be working if you can see this.");        
    }

    @Override
    public void init() {
        System.out.println("init method of OrderBusinessService was just called");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of OrderBusinessService was just called in.");        
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public OrderModel getOne(int id) {
        return ordersDAO.getById(id);
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public int addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(idToUpdate, updateOrder);
    }

    
    
}
