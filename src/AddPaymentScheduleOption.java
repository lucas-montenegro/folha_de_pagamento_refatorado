import java.util.ArrayList;

public class AddPaymentScheduleOption implements Menu {
    public void doOption(ArrayList<Employee> employees,  ArrayList<PaymentSchedule> paymentSchedule) {
        PaymentSchedule newPaymentSchedule = new PaymentSchedule();
        newPaymentSchedule.addPaymentSchedule();
        paymentSchedule.add(newPaymentSchedule);
        System.out.println("Agenda adicionada com sucesso!");
    }
}
