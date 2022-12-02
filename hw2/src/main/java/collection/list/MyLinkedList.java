package collection.list;

import collection.MyList;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private IteratorImpl iterator =  new IteratorImpl();

    private int size = 0;

    public MyLinkedList(T... args) {
        for (T arg: args) {
            add(arg);
        }
    }

    @Override
    public T get(int position) {
        if (size == 0 && position == 0 ) {
           return null;
        }
        if (position <= 0 || position >= size) {
            throw new RuntimeException(String.format("The position %s is out of range the list", position));
        }
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.elem;
    }

    @Override
    public void add(T element) {
        Node<T> lastNode = tail;
        Node<T> newNode = new Node<>(element);
        tail = newNode;
        if (lastNode == null) {
            head = newNode;
        } else {
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        size++;
    }

    @Override
    public void insert(T element, int position) {
        Node<T> current = head;
        Node<T> newNode = new Node<>(element);
        if (position <= 0 || position >= size) {
            throw new RuntimeException(String.format("The position %s is out of range the list", position));
        }
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        link(current.prev,newNode);
        size++;
    }

    private void link(Node<T> current, Node<T> newNode) {
        if (current.next != null) {
            newNode.next = current.next;
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    private T unLink(Node<T> node) {
        T element = node.elem;
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.elem = null;
        return element;
    }

    @Override
    public T delete(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.elem.equals(element)) {
                size--;
                return unLink(current);
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean contains(T c) {
        Node<T> node = new Node<>(c);
        Node<T> current = head;
        while (!current.equals(node)) {
            if (current.next == null) {
                return false;
            } else {
                current = current.next;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.elem);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    private class IteratorImpl implements Iterator<T> {
        Node<T> current;

        @Override
        public boolean hasNext() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.next != null;
        }

        @Override
        public T next() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            current = current.next;
            return current.prev.elem;
        }

        @Override
        public void remove() {
            unLink(current);
        }

        private boolean isExists() {
            return !(iterator == null);
        }

        private boolean isEnd() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.next == null;
        }

        private boolean isBegin() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.prev == null;
        }


    }
}
