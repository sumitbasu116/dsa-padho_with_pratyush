https://leetcode.com/problems/fruit-into-baskets/

maximum length of substring of at most 2 distinct Character.

class Solution {
    public int totalFruit(int[] a) {
        int low =0,high=0;
        int res = -1;
        int n = a.length;

        Map<Integer,Integer> helpMap = new HashMap<>();
        while(high<n){
            helpMap.put(a[high],helpMap.containsKey(a[high])?helpMap.get(a[high])+1:1);
            while(helpMap.size()>2){
                helpMap.put(a[low],helpMap.get(a[low])-1);
                if(helpMap.get(a[low])==0){
                    helpMap.remove(a[low]);
                }
                low++;
            }
            if(helpMap.size()==2 || helpMap.size()<2){
                res = Math.max(high-low+1,res);
            }
            high++;
        }
    return res;
    }
}