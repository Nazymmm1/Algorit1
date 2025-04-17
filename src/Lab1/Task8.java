//package Lab1;
//
//import java.util.Scanner;
//
//public class Task8 {
//    public static boolean noChar(char[] array,int index) {
//        if (index==array.length){
//                return true;
//            return true;
//>>>>>>> ca8776889488c381064535716cf056d6a7402a49
//        }
//        //if its out of range like before '0' or after '9' itll return false
//        if(array[index]<'0'|| array[index]>'9'){
//            return false;
//        }
//        return noChar(array,index+1);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
//        char array[]=s.toCharArray();
//        if (noChar(array,0)){
//            System.out.println("Yes");
//        }
//        else{
//            System.out.println("No");
//        }
//    }
//}