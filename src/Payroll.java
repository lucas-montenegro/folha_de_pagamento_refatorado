import java.util.ArrayList;

public class Payroll {
    private GenericPayment genericPayment = new GenericPayment();

    public GenericPayment getGenericPayment() { return genericPayment; }

    public void setGenericPayment(GenericPayment genericPayment) { this.genericPayment = genericPayment; }

    public void paySyndicate(Employee employee, double salary, double actualPayment) {
        if(employee.getSindycate().getOptionSyndicate() ==1) {
            double taxes = employee.getSindycate().getSyndicateTax();
            double total = (salary * taxes) / 100.0;
            actualPayment -= total;
            System.out.printf("O funcionário %s, de ID de sindicato %s, teve descontado %.2f de seu salário pela sua participação no sindicato!\n", employee.getName(), employee.getSindycate().getIdSyndicate(), total);
            employee.setActualPayment(actualPayment);
        }
    }

    public double paySyndicateService(Employee employee, double actualPayment) {
        if (employee.getSindycate().getServiceTax() != 0 && actualPayment >= 0.0) {
            double taxes = employee.getSindycate().getServiceTax();
            double total = (actualPayment * taxes) / 100.0;
            actualPayment -= total;
            System.out.printf("-%.2f de serviços do sindicato\n", total);
            employee.getSindycate().setServiceTax(0);
        }
        return actualPayment;
    }

    public void showDataBeforePayment(Employee employee, double actualPayment) {
        System.out.printf("Nome: %s | ID : %s\n", employee.getName(), employee.getId());
        System.out.printf("Sálario atual: %.2f\n", actualPayment);
    }

    public void showPaymentResult(double actualPayment) {
        System.out.println("----------------------------------");
        System.out.printf("Foi pago %.2f\n", actualPayment);
    }

    public void payEmployee(Employee employee, Calendario calendario, double actualPayment) {
        showDataBeforePayment(employee, actualPayment);
        actualPayment = paySyndicateService(employee, actualPayment);
        showPaymentResult(actualPayment);
        getGenericPayment().restartAcutalPayment(employee);
        employee.getGenericPayment().calculateNextPayment(calendario, employee);
    }

    public void runAndPayAllEmployees(ArrayList<Employee> employees, Calendario calendario, int day) {
        EmployeeIterator employeeIterator = new EmployeeIterator(employees);
        while(employeeIterator.hasNext()) {
            Employee e = ((Employee) employeeIterator.next());
            int daysToPayment = e.getDaysToPayment();
            double salary = e.getSalary(), actualPayment = e.getActualPayment();
            if (day == 1) { // syndicate´s day of payment
                paySyndicate(e, salary, actualPayment);
            }
            if (daysToPayment == 0) {
                payEmployee(e, calendario, actualPayment);
                getGenericPayment().showPaymentMethod(e);
            } else {
                System.out.printf("O funcionário %s não recebeu nenhum pagamento hoje\n\n", e.getName());
            }
            e.setDaysToPayment(e.getDaysToPayment() - 1);
        }
    }

    public void showPayrollData(Calendario calendario) {
        int day = calendario.getDay();
        int month = calendario.getMonth();
        int year = calendario.getYear();
        System.out.printf("Folha de pagamento realizada na data %d/%d/%d !\n", day, month, year);
    }


    public void payroll(ArrayList<Employee> employees, Calendario calendario) {
        runAndPayAllEmployees(employees, calendario, calendario.getDay());
        showPayrollData(calendario);
    }
}
