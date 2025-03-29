package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static int minimum(int index, ArrayList<Integer> array) {

        if (index == array.size() - 1) {
            return array.get(index);
        }


        return Math.min(array.get(index), minimum(index + 1, array));
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<num;i++){
            arrayList.add(sc.nextInt());
        }
        System.out.println(minimum(0,arrayList));

    }
}