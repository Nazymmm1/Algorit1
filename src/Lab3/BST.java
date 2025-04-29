package Lab3;

import java.util.*;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a key-value pair
    public void put(K key, V val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val; // Update value if key exists
        }
        return x;
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val; // Key found
            }
        }
        return null; // Key not found
    }

    // Delete a key-value pair
    public void delete(K key) {
        root = delete(root, key);
        size--;
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    // Return the number of nodes in the BST
    public int size() {
        return size;
    }

    // Iterator for in-order traversal
    public Iterable<Entry<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterable<Entry<K, V>> {
        @Override
        public java.util.Iterator<Entry<K, V>> iterator() {
            return new InOrderIterator();
        }

        private class InOrderIterator implements java.util.Iterator<Entry<K, V>> {
            private Stack<Node> stack = new Stack<>();
            private Node current = root;

            @Override
            public boolean hasNext() {
                return !stack.isEmpty() || current != null;
            }

            @Override
            public Entry<K, V> next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                Node next = current;
                current = current.right;
                return new Entry<>(next.key, next.val);
            }
        }
    }

    // Entry class to hold key-value pairs
    public static class Entry<K, V> {
        private K key;
        private V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
}