import java.util.ArrayList;
import java.util.Scanner;

public class Syndicate {
    private int optionSyndicate;
    private int idSyndicate;
    private double syndicateTax;
    private double serviceTax;
    private Excecao excecao = new Excecao();

    public Excecao getExcecao() { return excecao; }

    public void setExcecao(Excecao excecao) { this.excecao = excecao; }

    public int getIdSyndicate() { return idSyndicate; }

    public void setIdSyndicate(int idSyndicate) {
        this.idSyndicate = idSyndicate;
    }

    public int getOptionSyndicate() {
        return optionSyndicate;
    }

    public void setOptionSyndicate(int optionSyndicate) {
        this.optionSyndicate = optionSyndicate;
    }

    public double getSyndicateTax() {
        return syndicateTax;
    }

    public void setSyndicateTax(double syndicateTax) {
        this.syndicateTax = syndicateTax;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }

    public void resetServiceTax() {
        setSyndicateTax(0);
    }

    public void addServiceTax(ArrayList<Employee> employees) {
        Employee employee = new Employee();
        System.out.println("Digite o id do funcionário que deseja lançar a taxa de serviço:");
        int idToVerify = excecao.loadInt();
        employee = employee.searchEmployee(employees, idToVerify);
        if(employee == null) System.out.println("Não é possível lançar a taxa de serviço!");
        else {
            employee.newServiceTax(employee.getSindycate());
            System.out.println("Taxa de serviço adicionada com sucesso!");
        }
    }
}
