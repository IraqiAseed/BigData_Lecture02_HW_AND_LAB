package homework;

import java.util.Arrays;

public class Elist implements EpamList {

    private static final int INC = 1;
    private Object[] arr;
    private int size = 0;
    private int index = 0;

    Elist() {
        arr = new Object[INC];
        size++;

    }

    @Override
    public void add(Object o) {

        if (index == size) {
            size += INC;
            arr = Arrays.copyOf(arr, size);
        }

        arr[index] = o;
        index++;
    }

    @Override
    public int size() {
        return size;
    }

    //maybe can use arrays.copyof or system.arraycopy
    @Override
    public boolean remove(int i) {
        if (i >= size || i < 0 || size == 0)
            return false;

        for (int j = i + 1; j < arr.length; j++, i++) {
            arr[i] = arr[j];

        }
        size--;
        index--;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        boolean removed = false;
        if (size == 0)
            return false;

        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                remove(i);
                removed = true;
            }

        }

        return removed;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            return "INDEX OUT OF RANGE";
        }

        return arr[index];

    }

    @Override
    public void printAllContext() {
        for (int i = 0; i < size; i++) {

            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Elist list = new Elist();
        //Test 1
        list.add(5);
        list.add(10);
        list.add("TODO");
        list.remove(2);
        list.add("ODOT");
        list.printAllContext();
        System.out.println("second index:" + list.get(2));

        System.out.println("--------");
        //Test 2
        list.remove(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        list.add("TODO");
        list.add(5);
        list.add(10);
        list.printAllContext();
        System.out.println("second index:" + list.get(2));

        System.out.println("--------");
        //Test 3
        list.remove((Object) 10);
        list.printAllContext();
        System.out.println("second index:" + list.get(2));
        System.out.println("sixth index:" + list.get(6));

        System.out.println("--------");
        //Test 4
        list.remove("TODO");
        list.printAllContext();
        System.out.println("second index:" + list.get(2));
        System.out.println("length is :" + list.size());

        System.out.println("fourth index:" + list.get(4));

    }
}
