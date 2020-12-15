package component;

import entity.OrderDetailsEntity;
import entity.ProductEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session")
public class Cart {
    private List<OrderDetailsEntity> orderDetailsList;

    public Cart() {
        orderDetailsList = new ArrayList<OrderDetailsEntity>();
    }
    public void addItem(ProductEntity product){
        boolean t=false;
        for (int i=0; i<orderDetailsList.size(); i++){
            if (orderDetailsList.get(i).getProduct().getId()==product.getId()){
                OrderDetailsEntity orderDetails = orderDetailsList.get(i);
                orderDetails.setQuantity(orderDetails.getQuantity() +1);
                orderDetailsList.set(i,orderDetails);
                t=true;
            }
        }
        if(!t){
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setProduct(product);
            orderDetails.setQuantity(1);
            orderDetails.setPrice(product.getPrice());
            orderDetailsList.add(orderDetails);
        }
    }
    public void removeItem(ProductEntity product){

    }

    public List<OrderDetailsEntity> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsEntity> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
