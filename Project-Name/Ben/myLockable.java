public class myLockable<T> {
    private T locking;
    private boolean locked = false;

    public T getLocking() {
        return locking;
    }

    public void setLocking(T newVal) {
        if (locked = false) {
            locking = newVal;
        }
    }

    public void lock() {
        locked = true;
    }

}