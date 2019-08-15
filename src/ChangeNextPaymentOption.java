import java.util.ArrayList;

public class ChangeNextPaymentOption implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar a quantia do próximo contracheque:");
        int option = excecao.loadInt();
        if (option == 1) {
            employee.newActualPayment(employee);
        }
    }
}
