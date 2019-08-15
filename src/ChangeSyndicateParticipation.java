import java.util.ArrayList;

public class ChangeSyndicateParticipation implements ChangeDataMenu {
    private Excecao excecao = new Excecao();

    public void makeChange(Employee employee, ArrayList<Employee> employees) {
        System.out.println("Digite 1 para modificar a participação no sindicato:");
        int option = excecao.loadInt();
        if (option == 1) {
            employee.newSyndicateOption(employee.getSindycate());
            if (employee.getSindycate().getOptionSyndicate() == 0) {
                System.out.println("Como você saiu do sindicato o seu id e a sua taxa serão removidos automaticamente.");
                employee.getSindycate().setIdSyndicate(-1);
                employee.getSindycate().setSyndicateTax(0);
            }
        }
    }
}
