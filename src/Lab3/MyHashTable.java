package Lab3;

import java.util.Objects;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + key + " : " + value + "}";
        }
    }

    // Array of linked lists (chaining)
    private HashNode<K, V>[] chainArray;
    private int M = 11; // Default number of buckets
    private int size; // Number of elements in the hash table

    // Constructor
    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int M) {
        if (M <= 0) {
            throw new IllegalArgumentException("Number of buckets must be positive");
        }
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Insert a key-value pair into the hash table
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        // Check if the bucket is empty
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            // Traverse the linked list to check for existing key
            HashNode<K, V> current = chainArray[index];
            while (current != null) {
                if (Objects.equals(current.key, key)) {
                    // Key already exists, update the value
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            // Key does not exist, add it to the end of the list
            HashNode<K, V> last = chainArray[index];
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    // Remove a key-value pair from the hash table
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> previous = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (previous == null) {
                    // Removing the first node in the list
                    chainArray[index] = current.next;
                } else {
                    // Removing a node in the middle or end of the list
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null; // Key not found
    }

    // Check if a value exists in the hash table
    public boolean contains(V value) {
        for (HashNode<K, V> head : chainArray) {
            HashNode<K, V> current = head;
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    // Get the key associated with a value
    public K getKey(V value) {
        for (HashNode<K, V> head : chainArray) {
            HashNode<K, V> current = head;
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null; // Value not found
    }

    // Print the number of elements in each bucket
    public void printBucketSizes() {
        System.out.println("Bucket Sizes:");
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    // Size of the hash table
    public int size() {
        return size;
    }
}