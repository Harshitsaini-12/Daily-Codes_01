class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int mini=prices[0];

        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-mini;

            maxprofit=Math.max(profit,maxprofit);
            mini=Math.min(mini,prices[i]);
        }

        return maxprofit;
    }
}