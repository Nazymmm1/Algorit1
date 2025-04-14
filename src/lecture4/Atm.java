package lecture4;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Queue;

public class Atm {
    public static void main(String[] args) {
        //queue- is a FIFO structure which serves front element first(front in first object)

        Queue atm= new LinkedList();

        //Queue<Integer> atm= new LinkedList(); is also acceptable

        // is empty
        System.out.println(atm.isEmpty());

        //adding objects
        atm.add(5);
        atm.add(3);
        atm.add(19);

        System.out.println(atm.size());
        //returns the first element
        System.out.println(atm.peek());
        //deletes the first element and displays it
        System.out.println(atm.poll());
        System.out.println(atm.size());
    }

}