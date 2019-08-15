public class SingletonPaymentSchedule {
    private static PaymentSchedule instance = new PaymentSchedule();

    private SingletonPaymentSchedule() {}

    public static PaymentSchedule getInstance() {
        if(instance == null) {
            instance = new PaymentSchedule();
        }
        return instance;
    }
}
