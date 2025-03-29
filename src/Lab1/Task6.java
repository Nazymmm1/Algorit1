package Lab1;

import java.util.Scanner;

public class Task6 {
    public static int degree(int num,int deg) {
        int ans=1;
        if (deg==0){
            return 1;
        }
        //the toppest block will be 2*1(basecase) the 2*2 second layer then 2*4 third block and toll 10th original degree
        ans=num*degree(num,deg-1);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        int deg=sc.nextInt();

        System.out.println(degree(num,deg));

    }
}