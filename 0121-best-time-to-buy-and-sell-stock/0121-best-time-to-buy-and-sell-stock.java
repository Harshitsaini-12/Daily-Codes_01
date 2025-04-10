class Solution {
    public int maxProfit(int[] prices) {
        return helper(0,1,1,prices,new HashMap<String,Integer>());
    }

    public int helper(int si,int canBuy,int tran,int[]prices,HashMap<String,Integer>hm){

        if(tran<=0 || si>=prices.length)return 0;

        String key=si+"#"+canBuy+"#"+tran;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }

        if(canBuy==1){
            int idle=helper(si+1,canBuy,tran,prices,hm);
            int buy=-prices[si] + helper(si+1,0,tran,prices,hm);

            hm.put(key,Math.max(idle,buy));
            return Math.max(idle,buy);
        }else{
            int idle=helper(si+1,canBuy,tran,prices,hm);
            int sell=prices[si] + helper(si+1,1,-1,prices,hm);

            hm.put(key,Math.max(idle,sell));
            return Math.max(idle,sell);
        }

    }
}