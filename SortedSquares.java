https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        //separate positive and negative numbers
        for(int num : a){
            if(num<0){
                neg.add(num);
            }else{
                pos.add(num);
            }
        }
        //if all the numbers are negative
        if(pos.size()==0){
            Collections.reverse(neg);
            for(int i=0;i<n;i++){
                a[i]=neg.get(i)*neg.get(i);
            }
            return a;
        }
        //if all the numbers are positive
        else if(neg.size()==0){
            for(int i=0;i<n;i++){
                a[i]=pos.get(i)*pos.get(i);
            }
            return a;
        } 
        //if there are both positive and negative numbers
        for(int i=0;i<neg.size();i++){
            neg.set(i,neg.get(i)*neg.get(i));
        }
        Collections.reverse(neg);
        for(int i=0;i<pos.size();i++){
            pos.set(i,pos.get(i)*pos.get(i));
        }
        //merge the two arrays in sorted order
        int i=0,j=0;
        int id=0;
        while(i<neg.size() && j<pos.size()){
            if(neg.get(i)<pos.get(j)){
                a[id]=neg.get(i);
                i++;
                id++;
            }else if(neg.get(i)>=pos.get(j)){
                a[id]=pos.get(j);
                j++;
                id++;
            }
        }
        while(i<neg.size()){
            a[id]=neg.get(i);
            i++;
            id++;
        }  
        while(j<pos.size()){
            a[id]=pos.get(j);
            j++;
            id++;
        }
        return a;
    }
}