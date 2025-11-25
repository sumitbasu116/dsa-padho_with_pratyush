https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        char[] a = s.toCharArray();
        int d = 0;
        int maxC=0;
        int low = 0;
        int high=0;
        int n = a.length;
        int[] freq = new int[256];
        int res =Integer.MIN_VALUE;
        
        while(high<n){
            freq[a[high]]++;
            maxC = findMax(freq);
            int len = high-low+1;
            d = len - maxC;
            if(d<=k){
                res = Math.max(res,len);
            }
            while(d>k){
                freq[a[low]]--;
                maxC = findMax(freq);
                low++;
                len = high-low+1;
                d = len - maxC;
            }
            high++;
        }
        return res;
    }
    private int findMax(int[] a){
        int maxC=-1;
        for(int i=0;i<256;i++){
            maxC=Math.max(maxC,a[i]);
        }
        return maxC;
    }
}