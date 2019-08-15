import java.util.ArrayList;

public class ChangeNameOption implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar o nome:");
        int option = excecao.loadInt();
        if (option == 1) {
            employee.newName(employee);
        }
    }
}
