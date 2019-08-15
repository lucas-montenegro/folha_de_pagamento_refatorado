import java.util.ArrayList;

public class ChangeServiceTax implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar a taxa de serviço do sindicato:");
        int option = excecao.loadInt();
        if (option == 1) {
            employee.newServiceTax(employee.getSindycate());
        }
    }
}
