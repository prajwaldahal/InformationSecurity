package playfiar;

public class Index {
    private int i;
    private int j;
    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Index() {

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "Index{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
