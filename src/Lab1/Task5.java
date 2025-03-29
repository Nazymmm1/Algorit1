package Lab1;

import java.util.Scanner;

public class Task5 {
    public static int fibanachi(int num) {
        int ans=0;
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        ans=fibanachi(num-1)+fibanachi(num-2);
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        System.out.println(fibanachi(num));
    }
}