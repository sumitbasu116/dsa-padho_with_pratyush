https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


class Solution {
    public int maxProfit(int[] a) {
        int n = a.length;
        int buyingCost=a[0];
        int profit=0;
        int res = 0;
        for(int i=1;i<n;i++){
            int todayCost = a[i];
            profit = todayCost - buyingCost;
            if(todayCost<buyingCost){
                buyingCost = a[i];
            }
            if(profit>res){
                res = profit;
            }
        }
        return res;
    }
}

