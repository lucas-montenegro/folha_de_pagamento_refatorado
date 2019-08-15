import java.util.ArrayList;

public class JoinPaymentScheduleOption implements Menu{
    private Employee employeeAux = new Employee();
    private PaymentSchedule paymentScheduleAux = SingletonPaymentSchedule.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        employeeAux.allEmployees(employees);
        paymentScheduleAux.joinPaymentSchedule(employees, paymentSchedule);
    }
}
