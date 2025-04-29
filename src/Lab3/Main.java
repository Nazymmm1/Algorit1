package Lab3;

public class Main {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();

        bst.put("apple", 1);
        bst.put("banana", 2);
        bst.put("cherry", 3);


        System.out.println(bst.get("banana")); // Output: 2


        bst.delete("banana");


        for (BST.Entry<String, Integer> entry : bst.iterator()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("Size: " + bst.size());
    }
}