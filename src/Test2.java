/**
 * Created by peo_rboliveira on 23/03/16.
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(bestProfit(new int[]{10,8,7,5,3,6,7,6,4,6}));
    }

    public static int bestProfit(int[] priceHistory) {
        int max = 0;

        for (int i = 0; i < priceHistory.length-1; i ++) {
            for (int j = i; j < priceHistory.length; j++) {
                int maxTemp = priceHistory[j] - priceHistory[i];
                if (maxTemp > max) {
                    max = maxTemp;
                }
            }
        }

        return max;
    }
}
