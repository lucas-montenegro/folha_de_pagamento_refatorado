import java.util.ArrayList;

public class Commissioned extends Employee {
    private double commission;

    public double getCommission() { return commission; }

    public void setCommission(double commission) { this.commission = commission; }

    public void newCommission(Commissioned employee) {
        double commission;
        System.out.println("Digite o valor da comissão:");
        while(true) {
            commission = employee.getExcecao().loadDouble();
            if(getVerifyCorrectInput().verifyCommission(commission) == 0) { break; }
        }
        employee.setCommission(commission);
    }

    public int verifySale(double sale) {
        if(sale >= 0) {
            return 0;
        }
        else {
            System.out.println("Digite um valor válido!");
            return 1;
        }
    }


    public void addSale(Employee employee) {
        System.out.println("Digite o valor da venda:");
        double sale;
        while(true) {
            sale = getExcecao().loadDouble();
            if(verifySale(sale) == 0) {
                break;
            }
        }
        double commission = ((Commissioned)employee).getCommission();
        employee.getGenericPayment().updateActualPayment((sale * commission) / 100, employee);
    }

    public void throwSale(ArrayList<Employee> employees) {
        allEmployees(employees);
        System.out.println("Digite o id do funcionário que deseja lançar a venda(apenas comissionados):");
        int idToVerify = getExcecao().loadInt();
        Employee employee = searchEmployee(employees, idToVerify);
        if(employee == null || !(employee instanceof Commissioned)) System.out.println("Não é possível lançar a venda!");
        else {
            addSale(employee);
            System.out.println("Venda lançada com sucesso!");
        }
    }
}
