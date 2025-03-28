package Lab1;

import java.util.Scanner;

public class Task3 {
    public static boolean prime(int num) {
        boolean f= true;
        if (num==1 || num==0){
            return f;
        }
        for (int i=2;i<num;i++){
            if (num%i==0){
                f=false;
                break;
            }
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        boolean prime = prime(num);
        if (prime){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not prime");
        }
    }
}