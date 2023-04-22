package HeapDS;

import java.util.ArrayList;

public interface HeapInterface <T extends Comparable<T>>{
    int size();
    int height();
    boolean contains(T element);
    T top();
    void clear();
    void print();
    void insert(T element);
    void delete();
    ArrayList<T> heapSort(ArrayList<T> elements);
}