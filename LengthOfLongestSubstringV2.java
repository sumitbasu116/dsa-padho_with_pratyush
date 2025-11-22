https://leetcode.com/problems/longest-substring-without-repeating-characters/



class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int low=0;
        int high=0;
        int res = 0;
        Map<Character,Integer> helpMap = new HashMap<>();
        while(high<n){
            helpMap.put(a[high],helpMap.containsKey(a[high])?helpMap.get(a[high])+1:1);
            int len = high-low+1;
            if(helpMap.size()==len){
                res = Math.max(res,len);
            } while(helpMap.size()<len){
                helpMap.put(a[low],helpMap.get(a[low])-1);
                if(helpMap.get(a[low])==0){
                    helpMap.remove(a[low]);
                }
                low++;
                len = high-low+1;
            }
            high++;
        }
        return res;
    }
}