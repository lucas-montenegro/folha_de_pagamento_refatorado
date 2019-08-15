import java.util.ArrayList;

public class AddEmployeeOption implements Menu {
    private Employee employeeAux = new Employee();
    private PaymentSchedule paymentScheduleAux = SingletonPaymentSchedule.getInstance();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        employees.add(employeeAux.addEmployee(employees, paymentScheduleAux, calendario));
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
