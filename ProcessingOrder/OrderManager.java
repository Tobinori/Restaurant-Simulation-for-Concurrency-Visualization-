package ProcessingOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import FoodComponents.Food;

public class OrderManager{
    private ArrayList<Order> openOrders;
    private ArrayList<Order> announcedOrders;
    private int MAX_ORDERS = 30;
    private ScheduledExecutorService orderAnnouncer;
    private ArrayList<Food> foodToBeProcessed;
    private Lock mutex = new ReentrantLock();
    private Condition notEmpty = mutex.newCondition();
    private Condition notFull = mutex.newCondition();
    private int orderCount = 0;
    

    //The open orders are collected here. Usually, at most 6 orders are announced to the employees at a time.
    //After the orders are announced, they are moved to the announcedOrders list.
    //The announced orders are then processed by the employees.
    //Only after the announced orders are processed, new orders are announced.
    //The OrderManager class is responsible for managing the orders and announcing them to the employees.
    public OrderManager() {
        openOrders = new ArrayList<Order>();
        announcedOrders = new ArrayList<Order>();
    }

    public void addOrder(Order order) throws InterruptedException{
        mutex.lock();
        try {
            while (openOrders.size() == MAX_ORDERS) {
                notFull.await();
            }
            openOrders.addLast(order);
            orderCount++;
            notEmpty.signal();
        } finally {
            mutex.unlock();
        }
    }

    public ArrayList<Order> getNewOrders() {
        for (int i = 0; i < MAX_ORDERS ; i++) {
            announcedOrders.add(openOrders.get(i));
        }
        return announcedOrders;
    }

    public Order getNewOrder() throws InterruptedException {
        mutex.lock();
        Order announcedOrder;
        try {
            while (openOrders.size() == 0) {
                notEmpty.await();
            }
            announcedOrder = openOrders.get(0);
            openOrders.remove(0);
            announcedOrders.add(announcedOrder);
            notFull.signal();
        } finally {
            mutex.unlock();
        }
        return announcedOrder;
    }
}
