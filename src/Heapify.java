import java.util.ArrayList;

public class Heapify<T extends Comparable<T>> {

    private ArrayList<T> elements = new ArrayList<>();

    public Heapify(ArrayList<T> elements) {
        this.elements = elements;
    }

    private void print(){
        System.out.print("[");
        for(int i = 0; i < elements.size(); i++){
            System.out.print(elements.get(i));
            if(i != elements.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    private void swap(int idx1, int idx2){
        T temp = elements.get(idx1);
        elements.set(idx1, elements.get(idx2));
        elements.set(idx2, temp);
    }
    public ArrayList<T> maxHeapify() {
        if (elements.isEmpty()){
            System.out.println("[]");
            return null;
        }
        int size = elements.size();
        for (int i = elements.size() - 1; i >= 0; i--) {
            int parentIdx = i, leftChildIdx = i * 2 + 1, rightChildIdx = i * 2 + 2, max;
            while (true) {
                if (leftChildIdx >= size) {
                    break;
                } else if (leftChildIdx < size && rightChildIdx >= size) {
                    max = elements.get(leftChildIdx).hashCode();
                } else {
                    max = Math.max(elements.get(leftChildIdx).hashCode(), elements.get(rightChildIdx).hashCode());
                }
                if (parentIdx == size - 1 || elements.get(parentIdx).hashCode() > max) break;

                if (max == elements.get(leftChildIdx).hashCode()) {
                    swap(parentIdx, leftChildIdx);
                    parentIdx = leftChildIdx;
                } else {
                    swap(parentIdx, rightChildIdx);
                    parentIdx = rightChildIdx;
                }
                leftChildIdx = parentIdx * 2 + 1;
                rightChildIdx = parentIdx * 2 + 2;
            }
        }
        print();
        return elements;
    }
    public ArrayList<T> minHeapify() {
        if (elements.isEmpty()){
            System.out.println("[]");
            return null;
        }
        int size = elements.size();
        for (int i = elements.size() - 1; i >= 0; i--) {
            int parentIdx = i, leftChildIdx = i * 2 + 1, rightChildIdx = i * 2 + 2, min;
            while (true) {
                if (leftChildIdx >= size) {
                    break;
                } else if (leftChildIdx < size && rightChildIdx >= size) {
                    min = elements.get(leftChildIdx).hashCode();
                } else {
                    min = Math.min(elements.get(leftChildIdx).hashCode(), elements.get(rightChildIdx).hashCode());
                }
                if (parentIdx == size - 1 || elements.get(parentIdx).hashCode() < min) break;

                if (min == elements.get(leftChildIdx).hashCode()) {
                    swap(parentIdx, leftChildIdx);
                    parentIdx = leftChildIdx;
                } else {
                    swap(parentIdx, rightChildIdx);
                    parentIdx = rightChildIdx;
                }
                leftChildIdx = parentIdx * 2 + 1;
                rightChildIdx = parentIdx * 2 + 2;
            }
        }
        print();
        return elements;
    }
}
