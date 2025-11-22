https://leetcode.com/problems/sort-colors/
best time: https://youtu.be/ljJJcYql6Bc?list=PLbJhGqY-mq47k_WLUtzVjmarUm1EuXPj2&t=1982 
class Solution {
    public void sortColors(int[] a) {
        int low = 0;
        int mid = 0;
        int n = a.length;
        int high = n-1;
        while(mid<=high){
            if(a[mid]==0){
                swap(mid,low,a);
                mid++;
                low++;
            } else if(a[mid]==1){
                mid++;
            } else if(a[mid]==2){
                swap(mid,high,a);
                high--;
            }
        }
    }
    private void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
