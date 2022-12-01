package collection.array;


import collection.MyList;
import java.util.Iterator;

public class Array<T> implements MyList<T> {
    private T[] arr;
    private int size;

    private Array() {

    }

    public Array(int capacity, Class<T> c) {
        this();
        arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    public Array(T... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    @Override
    public void add(T element) {
        verifyCapacity();
        arr[size++] = element;
    }

    @Override
    public void insert(T element, int position) {
        if (position < 0 || position >= size) {
            throw new ArrayIndexOutOfBoundsException(position);
        } else {
            verifyCapacity();
            copyRightOfInx(position);
            arr[position] = element;
            size++;
        }
    }

    @Override
    public T delete(T element) {
        int index = -1;
        for (int i=0 ;i<size ;i++) {
            if (arr[i].equals(element)) {
              index = i;
              break;
            }
        }
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T temp = arr[index];
        copyLeftOfInx(index);
        size--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T c) {
        for (int i=0 ;i<size ;i++) {
            if (arr[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private void increaseCapacity() {
        T[] temp = arr;
        arr = (T[])new Object[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }


    public void verifyCapacity() {
        if (size >= arr.length) {
            increaseCapacity();
        }
    }

    private void copyLeftOfInx(int inx) {
        System.arraycopy(arr, inx + 1, arr, inx, size - inx - 1);
    }

    private void copyRightOfInx(int inx) {
        System.arraycopy(arr, inx, arr, inx + 1, size - inx - 1);
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
