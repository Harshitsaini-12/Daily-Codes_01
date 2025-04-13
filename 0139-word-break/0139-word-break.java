class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>hm=new HashSet<>();
        int len=0;
        int n=s.length();

        for(String ss:wordDict){
            hm.add(ss);
            len=Math.max(len,ss.length());
        }

        boolean[]dp=new boolean[n+1];
        dp[0]=true;

        for(int i=0;i<=n;i++){
            if(!dp[i])continue;

            for(int l=1;l<=len && i+l<=n;l++){
                String ss=s.substring(i,i+l);
                if(hm.contains(ss)){
                    dp[i+l]=true;
                }
            }
        }

        return dp[n];
    }
}