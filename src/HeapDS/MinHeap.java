package HeapDS;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> extends Heap<T> implements HeapInterface<T>{
    public void insert(T element){
        heapList.add(element);
        int childIdx = this.size() - 1, parentIdx = (int) Math.floor((childIdx - 1) / 2);
        while((heapList.get(parentIdx).hashCode() > heapList.get(childIdx).hashCode()) && (childIdx != 0)){
            swap(childIdx, parentIdx);
            childIdx = parentIdx;
            parentIdx = (int) Math.floor((childIdx - 1) / 2);
        }
    }
    public void delete(){
        if(isEmpty()) return;
        swap(0, size() - 1);
        heapList.remove(size() - 1);
        int parentIdx = 0, leftChildIdx = 1, rightChildIdx = 2, min;
        while(true){
            if(leftChildIdx >= size()){
                break;
            }
            else if(leftChildIdx < size() && rightChildIdx >= size()){
                min = heapList.get(leftChildIdx).hashCode();
            }
            else{
                min = Math.min(heapList.get(leftChildIdx).hashCode(), heapList.get(rightChildIdx).hashCode());
            }
            if(parentIdx == size() - 1 || heapList.get(parentIdx).hashCode() < min) break;

            if(min == heapList.get(leftChildIdx).hashCode()){
                swap(parentIdx, leftChildIdx);
                parentIdx = leftChildIdx;
            }
            else {
                swap(parentIdx, rightChildIdx);
                parentIdx = rightChildIdx;
            }
            leftChildIdx = parentIdx * 2 + 1;
            rightChildIdx= parentIdx * 2 + 2;
        }
    }
    public ArrayList<T> heapSort(ArrayList<T> elements){
        if(elements.isEmpty()){
            System.out.println("[]"); return null;
        }
        clear();
        for(int i = 0; i < elements.size(); i++){
            insert(elements.get(i));
        }
        elements.clear();
        while(!isEmpty()){
            elements.add(top());
            delete();
        }
        heapList = elements;
        print();
        return heapList;
    }
}
