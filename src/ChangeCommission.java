import java.util.ArrayList;

public class ChangeCommission implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar a comissão:");
        int option = excecao.loadInt();
        if (option == 1) {
            ((Commissioned) employee).newCommission(((Commissioned) employee));
        }
    }
}
