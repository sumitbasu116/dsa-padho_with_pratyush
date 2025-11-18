https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int low=0,high=0;
        int n = a.length;
        int res = 0;
        Map<Character,Integer> helpMap = new HashMap<>();
        while(high<n){
            helpMap.put(a[high],helpMap.containsKey(a[high])?helpMap.get(a[high])+1:1);
            int k = high-low+1;
            while(helpMap.size()<k){
                helpMap.put(a[low],helpMap.get(a[low])-1);
                if(helpMap.get(a[low])==0){
                    helpMap.remove(a[low]);
                }
                low++;
                k = high-low+1;
            }
            int len = high-low+1;
            res = Math.max(res,len);
            high++;
        }
        return res;
    }
}