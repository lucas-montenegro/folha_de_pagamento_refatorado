import java.util.ArrayList;

public class TimecardOption implements Menu {
    private Hourly hourlyAux = new Hourly();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        hourlyAux.timecard(employees);
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
