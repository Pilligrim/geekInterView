package collection.array;

import collection.MyList;

public class ArrayTest {
    public static void main(String[] args) {
        MyList array = new Array(1, -2, -3, -4, 5);
        System.out.println(array);
        System.out.println("size ->"+array.size());
        System.out.println(array.delete(-2));
        array.add(2);
        System.out.println("contains(-3) ->"+ array.contains(-3));
        System.out.println("array.isEmpty()->"+array.isEmpty());
        array.insert(6,1);
        System.out.println(array);
    }
}
