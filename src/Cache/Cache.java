package Cache;

public abstract class Cache<T> {
    protected int MAX_CAPACITY,currentCapacity;
    public abstract void put(int key,T value);
    public abstract T get(int key);

}
