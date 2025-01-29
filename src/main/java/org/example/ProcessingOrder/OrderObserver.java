package org.example.ProcessingOrder;

public interface OrderObserver {

    void  onOrderCompleted(Order order);
    
}
