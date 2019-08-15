import java.util.ArrayList;

public class ChangeEmployeeType implements ChangeDataMenu {
    private Excecao excecao = new Excecao();
    private Calendario calendario = SingletonCalendario.getInstance();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar o tipo de empregado:");
        int option = excecao.loadInt();
        Employee newEmployee;
        if (option == 1) {
            newEmployee = employee.createEmployee();
            if(newEmployee instanceof Commissioned) { ((Commissioned) newEmployee).newCommission(((Commissioned) newEmployee)); }
        }
        else {
            newEmployee = employee;
            if(newEmployee instanceof Commissioned) {
                ChangeDataMenu changeDataMenu = new ChangeCommission();
                changeDataMenu.makeChange(newEmployee, employees);
            }
        }
        employee.copyEmployee(employee, newEmployee);
        employee.removeRestartAndAddEmployee(employees, employee, newEmployee, calendario);
    }
}
