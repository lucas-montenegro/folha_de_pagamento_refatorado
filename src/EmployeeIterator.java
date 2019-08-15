import java.util.ArrayList;

public class EmployeeIterator implements Iterator {
    private ArrayList<Employee> employees;
    private int position = 0;

    public EmployeeIterator(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Object next() {
        Employee employee = employees.get(position);
        position++;
        return employee;
    }

    public boolean hasNext() {
        if (position >= employees.size()) {
            return false;
        } else {
            return true;
        }
    }
}
