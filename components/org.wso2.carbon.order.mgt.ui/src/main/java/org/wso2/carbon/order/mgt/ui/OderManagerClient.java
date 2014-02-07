package org.wso2.carbon.order.mgt.ui;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.wso2.carbon.order.mgt.data.xsd.Order;

import java.lang.Exception;
import java.rmi.RemoteException;

/**
 * Order Manager Web Service Client
 */
public class OderManagerClient {

    private OrderManagerStub stub;

    public OderManagerClient(ConfigurationContext configCtx, String backendServerURL, String cookie) throws AxisFault {
        String serviceURL = backendServerURL+"OrderManager";
        stub = new OrderManagerStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options options = client.getOptions();
        options.setManageSession(true);
        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }

    public void addOrder(Order order) throws OrderManagerExceptionException {
        try{
            stub.addOrder(order);
        }catch (RemoteException e) {
            String msg = "Cannot add the order"
                    + " . Backend service may be unvailable";
            throw new RuntimeException(msg, e);
        }
    }

    public Order[] getAllOrders() {
        try{
            return stub.getAllOrders();
        }catch (RemoteException e) {
            String msg = "Cannot get list of order"
                    + " . Backend service may be unvailable";
            throw new RuntimeException(msg, e);
        }
    }
}
