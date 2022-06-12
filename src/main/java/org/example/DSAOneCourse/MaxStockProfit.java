package org.example.DSAOneCourse;

public class MaxStockProfit {

    public static void main(String[] args) {
        int[] prices = {5, 2, 6, 1, 4};
        int maxProfit = getMaxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }

    private static int getMaxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxSP = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxSP)
                maxSP = prices[i];
            else maxProfit = Math.max(maxProfit, maxSP - prices[i]);
        }
        return maxProfit;
    }

}
