class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxP = 0;

        for(int price : prices){
            if(price < minPrice ){
                minPrice = price;
            }
            int profit = price - minPrice;

            if(profit > maxP) maxP = profit;
        }
        return maxP;
        
    }
}
