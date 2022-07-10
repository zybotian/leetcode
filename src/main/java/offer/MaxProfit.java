package offer;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{1}));
        System.out.println(maxProfit.maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 5}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 5}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 7, 5}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 10, 5, 3, 6, 5}));
        System.out.println(maxProfit.maxProfit(new int[]{7, 5, 5, 5, 6, 5}));
        System.out.println(maxProfit.maxProfit(new int[]{5, 5, 5, 5, 5, 5}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // result[i]表示以prices[i]结尾的最大利润
        int[] result = new int[prices.length];
        // 初始化
        result[0] = 0;
        // 截止到prices[i]的最低价格
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            result[i] = Math.max(result[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return result[result.length - 1];
    }
}
