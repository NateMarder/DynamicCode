import java.util.Calendar;

/**
 * Program Author: Nathan Marder
 *
 * A recursive fibonacci method works fantastic,
 * but it also includes many redundant calculations.
 * Adding some dynamic programming removes these
 * redundant calculations, providing a dramatically 
 * quicker algorithm. See for yourself.
 * 
 */
public class Fibonacci {

    private static int[] buffer = new int[5000000]; // buffer for dynamic method (line 47)

    public static void main(String[] args) {
        long startTime,result,endTime;

        // test old-school recursive fibonacci
        startTime = Calendar.getInstance().getTimeInMillis();
        result = slowFib(40);
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.printf("\nRecursive Fib at [40] is = %s :: required time-->[%s] milliseconds\n",result,endTime-startTime);

        // test fibonacci method with dynamic programming
        startTime = Calendar.getInstance().getTimeInMillis();
        result = fastFib(45);
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.printf("\nDynamic Fib at [45] is = %s :: required time-->[%s] milliseconds\n",result,endTime-startTime);
    }


    // without dynamic programming
    private static int slowFib(int n){

        if (n==0) return 0;
        if (n==1) return 1;

        return slowFib(n - 1) + slowFib(n-2);
    }

    // with dynamic programming
    private static int fastFib(int n){

        // do each calculation once and only once
        if (buffer[n] != 0) return buffer[n];

        // base cases
        if (n == 0) return buffer[0] = 0;
        if (n == 1) return buffer[1] = 1;

        // place value into buffer & recurse
        return buffer[n] = fastFib(n-1) + fastFib(n-2);
    }
}
