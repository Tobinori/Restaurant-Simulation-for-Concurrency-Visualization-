package ProcessingOrder;

import ProcessingFood.Employee;
import FoodComponents.Food;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EmployeeManager {
    ArrayList<Employee> employees;
    ExecutorService employeeExecutor;
    OrderManager orderManager;
    
    public EmployeeManager(OrderManager orderManager) {
        orderManager = this.orderManager;
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
    }

    public void giveOrder() {
        ArrayList<Order> newOrders = orderManager.getNewOrders();
        for (Order order : newOrders) {
            for (Food food : order.getOrder()){
                for (Employee employee : employees) {
                    if (employee.getPosition() == food.getPosition()) {
                        employee.addFoodToMemory(food);
                        break;
                    }
                }
            }
        }
    }
}
