package lecture4;

import java.util.Stack;

public class LogicalDS {
    public static void main(String[] args) {
        //Stack is a LIFO structure when the last element comes first
        //Every function here have O(1)
        Stack stack= new Stack();

        System.out.println(stack.isEmpty());

        stack.add("Kiko");
        stack.add("Faebrlic");
        stack.add(7);
        stack.push("Mimo");

        System.out.println(stack.size());
        // returns the last element
        System.out.println(stack.peek());
        //returns and deletes the last element
        System.out.println(stack.pop());


    }
}