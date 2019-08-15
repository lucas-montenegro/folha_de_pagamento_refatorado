import java.util.ArrayList;
import java.util.Scanner;

public class PaymentSchedule {
    private int dayWeekly;
    private int dayBiWeekly;
    private int dayMonth;
    private Excecao excecao = new Excecao();
    private VerifyCorrectInput verifyCorrectInput = new VerifyCorrectInput();

    public Excecao getExcecao() {
        return excecao;
    }

    public void setExcecao(Excecao excecao) {
        this.excecao = excecao;
    }

    public int getDayWeekly() {
        return dayWeekly;
    }

    public void setDayWeekly(int dayWeekly) {
        this.dayWeekly = dayWeekly;
    }

    public int getDayBiWeekly() {
        return dayBiWeekly;
    }

    public void setDayBiWeekly(int dayBiWeekly) {
        this.dayBiWeekly = dayBiWeekly;
    }

    public int getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(int dayMonth) {
        this.dayMonth = dayMonth;
    }

    public void showDetailsOfPaymentSchedule(PaymentSchedule paymentSchedule) {
        System.out.println("Agenda de pagamentos:");
        System.out.printf("Dia Mensal: %d\n", paymentSchedule.getDayMonth());
        System.out.printf("Dia Bi-Semanal: %d\n", paymentSchedule.getDayBiWeekly());
        System.out.printf("Dia Semanal: %d\n", paymentSchedule.getDayWeekly());
    }

    public PaymentSchedule choosePaymentSchedule(ArrayList<PaymentSchedule> paymentSchedule) {
        PaymentScheduleIterator paymentScheduleIterator = new PaymentScheduleIterator(paymentSchedule);
        while(paymentScheduleIterator.hasNext()) {
            PaymentSchedule k = ((PaymentSchedule)paymentScheduleIterator.next());
            showDetailsOfPaymentSchedule(k);
            int option = verifyCorrectInput.verifyPaymentSchedule();
            if(option == 1) { return k; }
        }
        return null;
    }

    public void choosePaymentType(Employee employee, PaymentSchedule paymentSchedule) {
        employee.setPaymentSchedule(paymentSchedule);
        int option = verifyCorrectInput.verifyPaymentScheduleType();
            if (option == 1) { employee.setScheduleOption(1);
            } else if (option == 2) { employee.setScheduleOption(2);
            } else if (option == 3) { employee.setScheduleOption(3); }
    }

    public void joinPaymentSchedule(ArrayList<Employee> employees, ArrayList<PaymentSchedule> paymentSchedule) {
        Employee employeeAux = new Employee();
        PaymentSchedule paymentScheduleAux = null;
        System.out.println("Digite o id do funcionário que deseja aderir à uma agenda de pagamento:");
        int idToVerify = excecao.loadInt();
        if(verifyCorrectInput.verifyId(employees, idToVerify) == 1) {
                employeeAux = employeeAux.searchEmployee(employees, idToVerify);
                paymentScheduleAux = choosePaymentSchedule(paymentSchedule);
                if(paymentScheduleAux != null) { choosePaymentType(employeeAux, paymentScheduleAux);}
        }
        if(paymentScheduleAux == null) { System.out.println("Não foi possível aderir à uma agenda de pagamento!"); }
        else { System.out.println("O funcionário agora possui uma nova agenda de pagamento!"); }
    }

    public void addPaymentSchedule() {
        int dayMonth = verifyCorrectInput.verifyDayMonth();
        int dayBiWeekly = verifyCorrectInput.verifyDayBiWeekly();
        int dayWeekly = verifyCorrectInput.verifyDayWeekly();
        setDayMonth(dayMonth);
        setDayBiWeekly(dayBiWeekly);
        setDayWeekly(dayWeekly);
    }
}
