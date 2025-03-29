package Lab1;

import java.util.Scanner;

public class Task4 {
    public static int factotial(int num) {
        int ans=1;
        //1 is our base case
        if (num==1){
            return 1;
        }
        //first block is 5*fact(4) next block 4*fact(3) and so on till base case when we get returned 1
        ans=num*factotial(num-1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        System.out.println(factotial(num));
    }
}