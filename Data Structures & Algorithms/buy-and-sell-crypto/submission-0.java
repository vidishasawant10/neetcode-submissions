class Solution {
    public int maxProfit(int[] prices) {
        // to keep track of the max profit
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            for (int j = i+1; j< prices.length; j++){
                if(prices[i]< prices[j]){
                    int profit = prices[j] - prices[i];
                    if(profit > maxProfit){
                        maxProfit = profit;
                    }
                }
            }
        }
        return maxProfit;
        //prices[i] -price of coin on the ith day

        //sell date will be always future date 

        //else return 0
    }
}
