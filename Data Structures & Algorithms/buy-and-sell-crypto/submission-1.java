class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;          // buy pointer
        int j = 1;          // sell pointer
        int maxProfit = 0;  // best profit seen so far

        while (j < prices.length) {
            if (prices[j] < prices[i]) {
                // found a cheaper buy day → move i
                i = j;
            } else {
                // potential profit with current buy/sell pair
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {   // manual comparison (no Math.max)
                    maxProfit = profit;
                }
            }
            j++; // always move the sell pointer forward
        }

        return maxProfit;
    }
}
