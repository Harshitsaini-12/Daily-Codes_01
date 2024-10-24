class Solution {
    public int climbStairs(int n) {
        return helper(0,n,new HashMap<Integer,Integer>());
    }


    public int helper(int start, int n,HashMap<Integer,Integer>hm){


        if(start==n)return 1;
        else if(start>n)return 0;

        if(hm.containsKey(start)){
            return hm.get(start);
        }

        int x=helper(start+1,n,hm);
        int y=helper(start+2,n,hm);

        hm.put(start,x+y);
        return x+y;
    }
}