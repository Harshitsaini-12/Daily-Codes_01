class Solution {
    public int largestRectangleArea(int[] heights) {

      Stack<Integer>ls=new Stack<>();
      ls.push(0);
      int[] lb=new int[heights.length];
      lb[0]=-1;

      for(int i=1;i<heights.length;i++){
        while(ls.size()>0 && heights[ls.peek()]>=heights[i]){
            ls.pop();
        }

        if(ls.size()==0){
            lb[i]=-1;
        }else{
            lb[i]=ls.peek();
        }
        ls.push(i);
      }

      Stack<Integer>rs=new Stack<>();
        rs.push(heights.length-1);
         int []rb=new int[heights.length];
        rb[heights.length-1]=heights.length;
        
        for(int i=heights.length-2;i>=0;i--){
            while(rs.size()>0 && heights[i]<=heights[rs.peek()]){
                rs.pop();
            }
            
            if(rs.size()==0){
                rb[i]=heights.length;
            }else{
                rb[i]=rs.peek();
            }
            rs.push(i);
        }
       

       int area=Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            int w=rb[i]-lb[i]-1;
            int h=heights[i];

            int new_area=w*h;
            area=Math.max(new_area,area);
        }


        return area;
    }
}