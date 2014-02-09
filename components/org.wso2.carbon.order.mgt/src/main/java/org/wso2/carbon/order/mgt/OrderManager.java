package org.wso2.carbon.order.mgt;

import org.wso2.carbon.order.mgt.data.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order Services Class
 */
public class OrderManager {

    private Map<Long, Order> orderMap;

    /**
     * Order service constructor which iniitialize orderMap with 2 dummy object
     */
    public OrderManager() {
        orderMap = new HashMap<Long, Order>();

        Order order1 = new Order();
        order1.setOrderNumber(1L);
        order1.setCustomerName("Indika Sampath");
        order1.setLocation("Colombo");

        Order order2 = new Order();
        order2.setOrderNumber(2L);
        order2.setCustomerName("Janaka Sampath");
        order2.setLocation("Colombo");

        orderMap.put(order1.getOrderNumber(), order1);
        orderMap.put(order2.getOrderNumber(), order2);
    }

    /**
     * Add order to the orderMap
     * @param order
     * @throws Exception
     */
    public void addOrder(Order order) {
        if(order == null || order.getOrderNumber() == null){
            throw new RuntimeException("Invalid Order");
        }
        orderMap.put(order.getOrderNumber(), order);
    }

    /**
     * All order details returns
     * @return
     */
    public List<Order> getAllOrders(){
        List<Order> orderList = new ArrayList<Order>();
        for (Map.Entry<Long, Order> entry : orderMap.entrySet()) {
            orderList.add(orderMap.get(entry.getKey()));
        }
        return orderList;
    }
}
