class Solution {
    public void helper(int index,String s, List<List<String>>ans,List<String>ds){
        if(index==s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                helper(i+1,s,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))return false;
        }

        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        helper(0,s,ans,new ArrayList<>());
        return ans;
    }
}