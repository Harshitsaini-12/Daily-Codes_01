class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }

        if(h==piles.length)return max;

        int speed=Integer.MAX_VALUE;
        int lo=1;
        int hi=max;

        while(lo<=hi){
            int sp=lo+((hi-lo)/2);

            if(isPossible(sp,piles,h)){
                speed=sp;
                hi=sp-1;
            }else{
                lo=sp+1;
            }
        }

        return speed;
    }

    public boolean isPossible(int sp,int[]piles,int h){
        long time=0;

        for(int i=0;i<piles.length;i++){
            time+=(int)Math.ceil((piles[i]*1.0)/sp);
        }
        return time<=h;
    }
}