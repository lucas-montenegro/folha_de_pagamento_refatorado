import java.util.ArrayList;

public class ChangeSyndicateId implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar a identificação no sindicato:");
        int option = excecao.loadInt();
        if (option == 1 && employee.getSindycate().getOptionSyndicate() == 1) {
            employee.newIdSyndicate(employee.getSindycate(), employees);
        }
        else if(option == 1 && employee.getSindycate().getOptionSyndicate() == 0){
            System.out.println("Você não pertence ao sindicato!");
        }
    }
}
