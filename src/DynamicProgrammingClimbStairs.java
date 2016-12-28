/**
 * Created by peo_rboliveira on 27/12/16.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DynamicProgrammingClimbStairs {
    private Set<Integer> integerSet = new HashSet<>();

    private static int numberOfSteps(int n) {
        if (n < 1) return 0;
        return 1+numberOfSteps(n-1)+numberOfSteps(n-2)+numberOfSteps(n-3);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            int result = numberOfSteps(n);

            System.out.println(result);
        }
    }
}
