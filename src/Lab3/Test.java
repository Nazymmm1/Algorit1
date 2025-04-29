package Lab3;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String name = "Student" + i;
            int id = random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(name, id);

            String studentName = "Name" + i;
            int studentAge = random.nextInt(100);
            Student value = new Student(studentName, studentAge);

            table.put(key, value);
        }

        table.printBucketSizes();

        System.out.println("Total number of elements: " + table.size());
    }
}