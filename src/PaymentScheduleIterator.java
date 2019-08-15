import java.util.ArrayList;

public class PaymentScheduleIterator implements Iterator{
    private ArrayList<PaymentSchedule> paymentSchedule;
    private int position = 0;

    public PaymentScheduleIterator(ArrayList<PaymentSchedule> paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public Object next() {
        PaymentSchedule paymentScheduleAux = paymentSchedule.get(position);
        position++;
        return paymentScheduleAux;
    }

    public boolean hasNext() {
        if (position >= paymentSchedule.size()) {
            return false;
        } else {
            return true;
        }
    }
}
