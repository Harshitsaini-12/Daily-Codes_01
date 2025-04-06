class Solution {
    public int trap(int[] height) {
        Stack<Integer>st=new Stack<>();
        int ans=0;

        for(int i=0;i<height.length;i++){
            while(st.size()>0 && height[st.peek()]<=height[i]){
                int rm=i;
                int currheight=height[st.pop()];

                if(st.size()==0)break;

                int lm=st.peek();

                int width=rm-lm-1;
                ans+=(Math.min(height[lm],height[rm])-currheight)*width;
            }
            st.push(i);
        }


        return ans;

    }
}