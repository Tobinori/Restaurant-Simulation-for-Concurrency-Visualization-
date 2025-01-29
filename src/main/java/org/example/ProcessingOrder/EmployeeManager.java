package org.example.ProcessingOrder;

import org.example.ProcessingFood.ProcessingFood.Employee;
import org.example.ProcessingFood.ProcessingFood.EmployeeList;

import org.example.FoodComponents.Food;
import org.example.FoodComponents.Kitchen;
import org.example.controller.ValueHandler;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;



public class EmployeeManager {
    private ArrayList<Employee> employees;
    private ExecutorService employeeExecutor;
    private OrderManager orderManager;
    private Kitchen kitchen;
    private AtomicBoolean isRunning = new AtomicBoolean(true);
    private ValueHandler valueHandler;
    
    public EmployeeManager(OrderManager orderManager, Kitchen kitchen, ValueHandler valueHandler) {
        this.orderManager = orderManager;
        this.kitchen = kitchen;
        this.valueHandler = valueHandler;
        createEmployess();
    }

    private void createEmployess() {
        employees = new ArrayList<Employee>();
        for (EmployeeList employee : EmployeeList.values()) {
            employees.add(new Employee(employee, kitchen, valueHandler));
        }
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployeeList() {
        return employees;
    }

    public void start() {
        int totalEmployees = employees.size();
        employeeExecutor = Executors.newFixedThreadPool(totalEmployees);
        for (Employee employee : employees) {
            employeeExecutor.execute(employee);
        }
        try{
            while(isRunning.get()){
                giveOrder();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Employee Manager has been interrupted");
        }
        finally{
            employeeExecutor.shutdown();
            try{
                while(!employeeExecutor.awaitTermination(800, TimeUnit.MILLISECONDS))
                {
                    employeeExecutor.shutdownNow();}
                
            }
            catch (InterruptedException e){
                employeeExecutor.shutdownNow();
            }
        }   
    }

    public void stop() {
        isRunning.set(false);
    }

    public void giveOrder(){
        try{
            Order newOrder = orderManager.getNewOrder();
            for (Food food : newOrder.getOrder()){
                for (Employee employee : employees){
                    if (employee.getEmployee().getPosition() == food.getPosition()){
                        employee.addFoodToMemory(food);
                        food.setAssigned();
                        break;}
            }
            }
            for(Food food : newOrder.getOrder()){
                if(!food.isAssigned()){
                    for(Employee employee : employees){
                        if(!employee.isFull()){
                            employee.addFoodToMemory(food);
                            food.setAssigned();
                            break;
                        }
                    }
                }
            }
    }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }

    public String getMemory(String employeeName){
        for (Employee employee : employees){
            if (employee.getEmployee().getName().equals(employeeName)){
                return employee.getMemory();
            }
        }
        return "";
    }

    
}
