https://leetcode.com/problems/minimum-window-substring/description/


class Solution {
    public String minWindow(String s, String t) {
        int[] have = new int[256];
        int[] need = new int[256];
        int low =0,high=0;
        int res = Integer.MAX_VALUE;
        
        if(s.length()<t.length()){
            return new String("");
        }
        int start =-1;
        char[] target=t.toCharArray();
        char[] a = s.toCharArray();
        int n = a.length;
        for(int i=0;i<target.length;i++){
            have[target[i]]++;
        }
        while(high<n){
            need[a[high]]++;
            while(isMatch(have,need)){
                int len = high -low +1;
                if(len<res){
                    res = len;
                    start = low;
                }
                need[a[low]]--;
                low++;
            }
            high++;
        }
        if(res!=Integer.MAX_VALUE){
           return s.substring(start,res+start);
        }
        return new String("");
    }
    private boolean isMatch(int[] have,int[] need){
        for(int i=0;i<256;i++){
            if(need[i]<have[i]){
                return false;
            }
        }
        return true;
    }
}