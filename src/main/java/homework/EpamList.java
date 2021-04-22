package homework;

public interface EpamList {

    void add(Object o);

    int size();

    boolean remove(int i);


    //bonus
    boolean remove(Object o);

    Object get(int index);


    void printAllContext();
}
