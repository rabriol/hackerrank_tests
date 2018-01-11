package codefights.arcade;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by peo_rboliveira on 20/04/17.
 */
public class CenturyFromYear {
    /**
     * Given a year, return the century it is in. The first century spans from the year 1 up to and including the year
       100, the second - from the year 101 up to and including the year 200, etc.

       Example

       For year = 1905, the output should be
       centuryFromYear(year) = 20;
       For year = 1700, the output should be
       centuryFromYear(year) = 17.
     */
    public static void main(String[] args) {
        System.out.println(getCentury(101));
    }

    public static int getCentury(int year) {
        return new BigDecimal(year).divide(new BigDecimal(100), BigDecimal.ROUND_UP).intValue();
    }
}
