import java.util.ArrayList;

public class UndoRedoOption implements Menu{
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        undoRedo.doUndoRedo(employees, calendario);
    }
}
