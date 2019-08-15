import java.util.ArrayList;

public class PayrollOption implements Menu {
    private Payroll payroll = new Payroll();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        payroll.payroll(employees, calendario);
        calendario.nextDayOfWeek(calendario.getDayOfWeek());
        calendario.nextDay(calendario.getDay(), calendario.getMonth());
        calendario.nextMonth(calendario.getDay(), calendario.getMonth());
        calendario.nextYear(calendario.getDay(), calendario.getMonth(), calendario.getYear());
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
