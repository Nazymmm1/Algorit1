package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static double sum(ArrayList<Integer> array, int index) {
        if (index == array.size() - 1) {
            return array.get(index);
        }
        return array.get(index) + sum(array, index + 1);
    }


    public static double average(ArrayList<Integer> array) {
        if (array.isEmpty()) return 0;
        return sum(array, 0) / array.size();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<num;i++){
            arrayList.add(sc.nextInt());
        }
        System.out.println(average(arrayList));

    }
}