package collection.list;

import collection.MyList;
import collection.array.Array;

public class ListTest {
    public static void main(String[] args) {
        MyList list = new MyLinkedList(1, -2, -3, -4, 5);
        System.out.println(list);
        System.out.println("size ->"+list.size());
        System.out.println(list.delete(-2));
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        System.out.println("contains(-3) ->"+ list.contains(-3));
        System.out.println("array.isEmpty()->"+list.isEmpty());
        list.insert(6,1);
        System.out.println(list);
    }
}
