#https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
#timing out on site but I think straight convert from the .java, logic should be ok 

class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        
        length = len(prices)
        if length == 0 or length == 1:
        	return 0

        start = 0
        while start < length - 1 and prices[start] > prices[start + 1]:
        	start += 1

        if start == length - 1:
        	return 0

        profit = 0
        lower_price_exists = False
        keep_iterating = True

        while keep_iterating :
        	lower_price_exists = false

        	index = start + 1
        	while index in range(length):

        		if prices[start] < prices[index] and prices[index] - prices[start] > profit:
        			profit = prices[index] - prices[start]
        		elif prices[index] < prices[start] and not lower_price_exists:
        			start = index
        			lower_price_exists = True

        		index += 1

        	if not lower_price_exists or start == length - 2:
        		keep_iterating = False


        return profit