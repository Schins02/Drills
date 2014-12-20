//https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {
    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        if(length == 0 || length == 1)
            return 0;
            
        int start = 0;
        while((start < length - 1) && (prices[start] > prices[start + 1])){
            start++;
        }

        if(start == length - 2)
            return 0;
        
        int profit = 0;
        boolean lowerPriceExists = false;
        boolean keepIterating = true;

        while(keepIterating){
            lowerPriceExists = false;

	        for(int i = start + 1; i < length; i++){
	        	if(prices[start] < prices[i] && (prices[i] - prices[start]) > profit)
	                profit = prices[i] - prices[start];
	            else if(prices[i] < prices[start] && !lowerPriceExists){
	            	start = i;
	            	lowerPriceExists = true;
	            }
	        }

	        if(!lowerPriceExists || start == length - 2)
	        	keepIterating = false;
	    }
	    return profit;
    }
}