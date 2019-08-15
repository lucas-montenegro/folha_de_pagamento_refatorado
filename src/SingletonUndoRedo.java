public class SingletonUndoRedo {
    private static UndoRedo instance = null;

    private SingletonUndoRedo() {}

    public static UndoRedo getInstance() {
        if(instance == null) {
            instance = new UndoRedo();
        }
        return instance;
    }
}
