package poj.enumeration.easy;

import java.util.Scanner;
 
public class U725B {
 
    static boolean checkUnique(int abcde, int fghij) {
//    	用数组uni存放每个数字出现的次数
        int[] uni = new int[10];
        
//      将求商和求余相结合，求每个数字的出现次数
        // mod and then divide the number to get each digit (5 digits of number).
        uni[abcde / 10000]++; //求最高位
        uni[(abcde % 10000) / 1000]++;
        uni[(abcde % 1000) / 100]++;
        uni[(abcde % 100) / 10]++;
        uni[(abcde % 10) / 1]++;
 
        uni[fghij / 10000]++;
        uni[(fghij % 10000) / 1000]++;
        uni[(fghij % 1000) / 100]++;
        uni[(fghij % 100) / 10]++;
        uni[(fghij % 10) / 1]++;
        
//      检查是否每个数字有且仅有出现一次
        for (int i = 0; i < uni.length; i++) {
            if (uni[i] != 1) // if any slot of array is greater than 1 then they are not unique number
                return false;
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = 0;
        boolean first = true;
        int abcde = 0;
        while ((N = in.nextInt()) != 0) {
            boolean print = false; // for checking if we can find the solutions for N
 
            if (first == false) { // don't print blank line for the first output
                System.out.println();
            }
 
            for (int fghij = 1234; fghij <= 98765; fghij++) {
                abcde = fghij * N;
                if (abcde < 99999) {
                    if (checkUnique(abcde, fghij) == true) {
                        if (fghij / 10000 == 0) { // for inserting 0 in front of fghij
                            System.out.println(abcde + " / 0" + fghij + " = " + N);
                        } else {
                            System.out.println(abcde + " / " + fghij + " = " + N);
                        }
                        print = true;
                    }
                }
            }
 
            if (print == false) {
                System.out.println("There are no solutions for " + N + ".");
            }
 
            first = false;
        }
        in.close();
    }
}
