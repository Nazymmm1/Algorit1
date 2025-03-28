package Lab1;

import java.util.Scanner;

public class Task9 {

    public static int combination(int num,int smaller_num) {
        int ans=1;
        if (num==smaller_num){
            return 1;
        }
        if (smaller_num==0){
            return 1;
        }
        //thats just a given formula
        ans=combination(num-1,smaller_num-1)+combination(num-1,smaller_num);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        int smaller_num=sc.nextInt();

        System.out.println(combination(num,smaller_num));

    }
}