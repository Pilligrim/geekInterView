package collection;

public interface MyList<T> extends Iterable<T> {
    T get(int position);

    void add(T element);

    void insert(T element,int position);

    T delete(T element);

    boolean isEmpty();

    boolean contains(T c);

    int size();
}
