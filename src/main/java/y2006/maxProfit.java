package y2006;

public class maxProfit {

    public int maxProfit(int[] prices) {
        // max profit = max_price - min_price
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            System.out.println(i + " == " + minPrice + " == " + maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        maxProfit maxProfit = new maxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1000}));
    }
}
