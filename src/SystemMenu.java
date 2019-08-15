import java.util.ArrayList;

public class SystemMenu {
    private static VerifyCorrectInput verifyCorrectInput = new VerifyCorrectInput();
    private Calendario calendario = SingletonCalendario.getInstance();
    private UndoRedo undoRedo = SingletonUndoRedo.getInstance();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<PaymentSchedule> paymentSchedule = new ArrayList<>();
    private PaymentSchedule paymentScheduleAux = SingletonPaymentSchedule.getInstance();

    public void initializePayementSchedule() {
        paymentScheduleAux.setDayWeekly(5);
        paymentScheduleAux.setDayBiWeekly(5);
        paymentScheduleAux.setDayMonth(-1);
        paymentSchedule.add(paymentScheduleAux);
    }

    public void initializeCalendary() {
        int initialDay = verifyCorrectInput.verifyInitialDay();
        int dayOfWeek = verifyCorrectInput.verifyWeekDay();
        int day = verifyCorrectInput.verifyDay();
        int month = verifyCorrectInput.verifyMonth();
        int year = verifyCorrectInput.verifyYear();
        calendario.setInitialDay(initialDay);
        calendario.setDayOfWeek(dayOfWeek);
        calendario.setDay(day);
        calendario.setMonth(month);
        calendario.setYear(year);
        calendario.initializeCalendary();
    }

    public void initializeUndoRedo() {
        undoRedo.addUndo(employees, calendario);
    }

    public void runMenu() {
        int option = verifyCorrectInput.verifyMenuOption();
        SystemMenuType systemMenuType;
        while(option != 0) {
            systemMenuType = SystemMenuType.values()[option - 1];
            Menu menu = systemMenuType.obterTipoMenu();
            menu.doOption(employees, paymentSchedule);
            option = verifyCorrectInput.verifyMenuOption();
        }
    }

    public void initializeSystem() {
        initializePayementSchedule();
        initializeCalendary();
        initializeUndoRedo();
        runMenu();
        System.out.println("Obrigado por utilizar o sistema de folha de pagamento!");
    }
}
