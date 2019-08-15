public class SingletonCalendario {
    private static Calendario instance = null;

    private SingletonCalendario() {}

    public static Calendario getInstance() {
        if(instance == null) {
            instance = new Calendario();
        }
        return instance;
    }
}
