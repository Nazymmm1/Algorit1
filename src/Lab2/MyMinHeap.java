package Lab2;

import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }


    public void add(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }


    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }


        T root = heap.get(0);


        T last = heap.get(heap.size() - 1);


        heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }


    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }


    public boolean isEmpty() {
        return heap.size() == 0;
    }


    public int size() {
        return heap.size();
    }


    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }


    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest == index) {
                break; // Heap property satisfied
            }
            swap(index, smallest);
            index = smallest;
        }
    }


    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}