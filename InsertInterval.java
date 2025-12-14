https://leetcode.com/problems/insert-interval/


class Solution {
    public int[][] insert(int[][] a, int[] b) {
        int n = a.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n<1){
            a = new int[1][2];
            a[0][0]=b[0];
            a[0][1]=b[1];
            return a;
        }else if(n==1){
            List<Integer> el=null;
            if(a[0][0]>=b[0]){
                insert(list,b[0],b[1]);
                insert(list,a[0][0],a[0][1]);
            }else{
                insert(list,a[0][0],a[0][1]);
                insert(list,b[0],b[1]);
            }
            int[][] ans = new int[list.size()][2];
        int i=0;
        for(List<Integer> ele:list){
            ans[i][0]=ele.get(0);
            ans[i][1]=ele.get(1);
            i++;
        }
        return mergeIntervals(ans);
        }
        
        boolean insert=false;
        for(int i=0;i<n;i++){
            if(a[i][0]>=b[0] && insert==false){
                insert(list,b[0],b[1]);
                insert=true;
            }
            insert(list,a[i][0],a[i][1]);
        }
        if(insert==false){
            insert(list,b[0],b[1]);
        }
        int[][] ans = new int[list.size()][2];
        int i=0;
        for(List<Integer> ele:list){
            ans[i][0]=ele.get(0);
            ans[i][1]=ele.get(1);
            i++;
        }
        return mergeIntervals(ans);
    }
    
    private int[][] mergeIntervals(int[][] a){
        Arrays.sort(a,(a1,b1)->Integer.compare(a1[0],b1[0]));
        int n = a.length;
        if(n<=1){
            return a;
        }
        List<List<Integer>> res = new ArrayList<>();
        int start1=a[0][0];
        int end1=a[0][1];
        for(int i=1;i<n;i++){
            int start2=a[i][0];
            int end2=a[i][1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
                continue;
            }
            insert(res,start1,end1);
            start1=start2;
            end1=end2;
        }
        insert(res,start1,end1);
        if(res.size()==0){
           return a; 
        }
        int[][] ans = new int[res.size()][2];
        int i=0;
        for(List<Integer> ele:res){
            ans[i][0]=ele.get(0);
            ans[i][1]=ele.get(1);
            i++;
        }
        return ans;
    }
    private void insert(List<List<Integer>> res,int a,int b){
        List<Integer> e = new ArrayList<>();
            e.add(a);
            e.add(b);
            res.add(e);
    }
}