import java.util.ArrayList;

public class AddServiceOption implements Menu {
    private Employee employeeAux = new Employee();
    private Syndicate syndicateAux = employeeAux.getSindycate();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        employeeAux.allEmployees(employees);
        syndicateAux.addServiceTax(employees);
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
