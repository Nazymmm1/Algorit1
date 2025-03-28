package Lab1;

import java.util.Scanner;

public class Task7 {
    public static void reverse(int num,Scanner sc) {
        // basecase is 0, that means when num-1 is 0 we wont take any values
        if (num==0){
            return;
        }
        //here we enter the number
        int a= sc.nextInt();
        reverse(num-1,sc);
        //after reaching base case it starts printing values from the top for example if it was 1 2 3 the toppest
        //3 then 2 then 1
        System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        reverse(num,sc);
    }
}