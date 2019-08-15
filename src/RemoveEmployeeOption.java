import java.util.ArrayList;

public class RemoveEmployeeOption implements Menu {
    private Employee employeeAux = new Employee();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        employeeAux.removeEmployee(employees);
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
