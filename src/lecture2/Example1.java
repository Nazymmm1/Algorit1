package lecture2;

import java.util.Scanner;

public class Example1 {
    public static int sum(int[] arr) {
        int total=0;

        for (int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        int[] arr= new int[n];

        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        //first it watvhes time bedore the execution of codes and
        //then ater ecution and then substracts them from each other
        long time1= System.currentTimeMillis();
        double result=sum(arr);
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1 +"ms");

        System.out.println(result);

//        Big O notation is way to gind how fast the algorithm is
//        by finding its fornula
    }
}