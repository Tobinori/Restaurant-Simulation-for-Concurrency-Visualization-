package ProcessingFood;

public enum EmployeeList {

    DIEGO("Diego", KitchenPosition.COUNTER, 1.2,6, 28),
    Evelyn("Evelyn", KitchenPosition.GRILL, 1.5, 6, 28),
    RICHI("Richi", KitchenPosition.SALAD_STATION, 0.5, 3, 30),
    YOGA("Yoga", KitchenPosition.STOVE, 2, 6, 26)
    ;

    private final String name;
    private final KitchenPosition position;
    private final double salary;
    private final double speed;
    private final int maxOrderMemory;

    EmployeeList(String name, KitchenPosition position, double speed, int maxOrderMemory,  double salary) {
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.maxOrderMemory = maxOrderMemory;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public KitchenPosition getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxOrderMemory() {
        return maxOrderMemory;
    }

    public static EmployeeList getEmployee(String name) {
        for (EmployeeList employee : EmployeeList.values()) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
}
