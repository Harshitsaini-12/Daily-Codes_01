class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        HashMap<Character,Integer>hm=new HashMap<>();

        int right=0;
        int left=0;

        while(right<s.length()){

            if(hm.containsKey(s.charAt(right))){
                left=Math.max(left,hm.get(s.charAt(right))+1);
            }

            hm.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }


        return len;
    }
}