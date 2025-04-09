class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String>ans=new ArrayList<>();
        helper(0,0,s,"",ans);
        return ans;
    }

    public void helper(int pos,int i,String s,String ans ,List<String>res){

        if(i==s.length() || pos==4){
            if(i==s.length() && pos==4){
                res.add(ans.substring(0,ans.length()-1));
            }
            return;
        }

        helper(pos+1,i+1,s,ans + s.charAt(i) + ".",res);

        if(i+2<=s.length() && isValid(s.substring(i,i+2))){
            helper(pos+1,i+2,s,ans+ s.substring(i,i+2) + ".",res);
        }

        if(i+3<=s.length() && isValid(s.substring(i,i+3))){
            helper(pos+1,i+3,s,ans+ s.substring(i,i+3) + ".",res);
        }
    }

    public boolean isValid(String s){
        if(s.charAt(0)=='0')return false;

        int val=Integer.parseInt(s);
        return val<=255;
    }
}