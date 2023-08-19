package Cache;

public class Node<T> {
    private int key;
    private T val;

    public Node() {

    }

    public Node(int key, T val) {
        this.key = key;
        this.val = val;
        this.frequncy = 1;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public int getFrequncy() {
        return frequncy;
    }

    public void setFrequncy(int frequncy) {
        this.frequncy = frequncy;
    }

    private int frequncy;


}
