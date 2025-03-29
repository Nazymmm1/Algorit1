package Lab1;

import java.util.Scanner;

public class Task10 {
    public static int GCD(int num1,int num2) {
        int ans=1;
        //ex: 32 20
        //32=20*1+12    20=12*1+8   12=8*1+4    8=4*2+0
        if (num2==0){
            return num1;
        }
        return GCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        System.out.println(GCD(num1,num2));
    }
}