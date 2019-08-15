public class CalendaryIterator implements Iterator{
    private int [][] calendary = new int[12][3];
    private int i = 0;
    private int j = 0;

    public CalendaryIterator(int [][] calendary) {
        this.calendary = calendary;
    }

    public Object next() {
        int value = calendary[i][j];
        j++;
        if(j >= 3) {
            j = 0;
            i++;
        }
        return value;
    }

    public boolean hasNext() {
        if (i >= 12) {
            return false;
        } else {
            return true;
        }
    }
}
