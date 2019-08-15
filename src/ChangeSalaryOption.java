import java.util.ArrayList;

public class ChangeSalaryOption implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar o salário:");
        int option = excecao.loadInt();
        if (option == 1) {
            employee.newSalary(employee);
        }
    }
}
