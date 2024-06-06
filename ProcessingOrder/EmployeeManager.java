package ProcessingOrder;

import ProcessingFood.Employee;
import FoodComponents.Food;
import FoodComponents.Kitchen;
import ProcessingFood.EmployeeList;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class EmployeeManager {
    private ArrayList<Employee> employees;
    private ExecutorService employeeExecutor;
    private OrderManager orderManager;
    private Kitchen kitchen;
    
    public EmployeeManager(OrderManager orderManager, Kitchen kitchen) {
        this.orderManager = orderManager;
        this.kitchen = kitchen;
        createEmployess();
    }

    private void createEmployess() {
        employees = new ArrayList<Employee>();
        for (EmployeeList employee : EmployeeList.values()) {
            employees.add(new Employee(employee, kitchen));
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
        while(true){
            giveOrder();
        }
    }

    public void giveOrder(){
        try{
            Order newOrder = orderManager.getNewOrder();
            for (Food food : newOrder.getOrder()){
                for (Employee employee : employees){
                    if (employee.getEmployee().getPosition() == food.getPosition()){
                        employee.addFoodToMemory(food);
                        newOrder.completeFood(food);
                        food.setAssigned();
                        break;}
            }
            }
            for(Food food : newOrder.getOrder()){
                if(!food.isAssigned()){
                    for(Employee employee : employees){
                        if(!employee.isFull()){
                            employee.addFoodToMemory(food);
                            newOrder.completeFood(food);
                            food.setAssigned();
                            break;
                        }
                    }
                }
            }
    }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
