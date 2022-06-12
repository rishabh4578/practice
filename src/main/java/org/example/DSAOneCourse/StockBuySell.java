package org.example.DSAOneCourse;

public class StockBuySell {

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int maxProfitInSingleBuySell = getMaxProfitInSingleBuySell(prices);
        int maxProfitInMultipleBuySell = getMaxProfitInMultipleBuySell(prices);
        System.out.println("maxProfitInSingleBuySell: " + maxProfitInSingleBuySell + ", maxProfitInMultipleBuySell: " + maxProfitInMultipleBuySell);
    }

    private static int getMaxProfitInMultipleBuySell(int[] prices) {
        System.out.println("-----getMaxProfitInMultipleBuySell-----");
        if (prices.length < 2) return 0;
        int totalProfit = 0;
        int bpIdx = 0;
        int spIdx = 1;
        while (spIdx < prices.length) {
            if (prices[spIdx] < prices[spIdx - 1]) {
                System.out.println(String.format("adding BP: %s, SP: %s", prices[bpIdx], prices[spIdx - 1]));
                totalProfit += prices[spIdx - 1] - prices[bpIdx];
                bpIdx = spIdx;
            }
            spIdx++;
        }
        System.out.println(String.format("adding BP: %s, SP: %s", prices[bpIdx], prices[spIdx - 1]));
        totalProfit += prices[spIdx - 1] - prices[bpIdx];
        return totalProfit;
    }

    private static int getMaxProfitInSingleBuySell(int[] prices) {
        System.out.println("-----getMaxProfitInSingleBuySell-----");
        if (prices.length < 2) return 0;
        int spIdx = prices.length - 1;
        int bpIdx = prices.length - 2;
        int maxProfit = 0;
        while (bpIdx > -1) {
            if (prices[bpIdx] > prices[spIdx]) {
                spIdx = bpIdx;
                bpIdx--;
            } else {
                if (prices[spIdx] - prices[bpIdx] > maxProfit) {
                    System.out.println(String.format("comparing BP: %s, SP: %s", prices[bpIdx], prices[spIdx]));
                    maxProfit = prices[spIdx] - prices[bpIdx];
                }
                bpIdx--;
            }
        }
        return maxProfit;
    }
}
