class Solution {

    public class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }

        public int compareTo(Pair o){
            if(this.start!=o.start){
               return  this.start-o.start;
            }else{
                return o.end-this.end;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        Pair []pair=new Pair[intervals.length];

        for(int i=0;i<intervals.length;i++){
            pair[i]=new Pair(intervals[i][0],intervals[i][1]);
        }

        Arrays.sort(pair);

        Stack<Pair>st=new Stack<>();

       for(int i=0;i<intervals.length;i++){
            if(i==0){
                st.push(pair[0]);
            }else{
                Pair top=st.peek();

                if(top.end<pair[i].start){
                    st.push(pair[i]);
                }else{
                    top.end=Math.max(top.end,pair[i].start);
                }
            }
       }

       int[][]ans=new int[st.size()][2];

       for(int i=st.size()-1;i>=0;i--){
           Pair p=st.pop();
            
            ans[i][0]=p.start;
            ans[i][1]=p.end;
       }

       return ans;
    }
}