package techniquesconcepts;

import java.util.Scanner;

/**
 * Created by peo_rboliveira on 15/12/16.
 */
public class FibonacciNumbers {

    public static int fibonacci(int n) {
        if (n < 0) return 0;
        if (n < 2) return n;
        return fibonacci(n-1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
