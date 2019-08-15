import java.util.ArrayList;

public class AddSaleOption implements Menu {
    private Commissioned commissionedAux = new Commissioned();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();

    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        commissionedAux.throwSale(employees);
        undoRedo.clearRedo();
        undoRedo.addUndo(employees, calendario);
    }
}
