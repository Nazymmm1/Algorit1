package Lab2;
public class testing {

    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(30);
        heap.add(20);
        heap.add(10);

        System.out.println("Remove: " + heap.remove()); // 10
        System.out.println("Peek: " + heap.peek()); // 20
    }
}