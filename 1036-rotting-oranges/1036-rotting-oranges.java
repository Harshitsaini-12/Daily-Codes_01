class Solution {
    public class Pair{
        int row;
        int col;

        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public int orangesRotting(int[][] grid) {

        LinkedList<Pair>q=new LinkedList<>();

        int fresh=0;

        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.addLast(new Pair(i,j));
                }
            }
        }

        if(fresh==0)return 0;
        int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};

        int level=-1;

        while(q.size()>0){
            int size=q.size();
             level++;


            while(size-->0){
                Pair rem=q.removeFirst();

                for(int i=0;i<dir.length;i++){
                    int rdash=rem.row + dir[i][0];
                    int cdash=rem.col + dir[i][1];

                    if(rdash>=0 && cdash>=0 && rdash<n && cdash<m && grid[rdash][cdash]==1){
                        q.addLast(new Pair(rdash,cdash));
                        grid[rdash][cdash]=0;
                        fresh--;
                    }
                }
            }
        }

        if(fresh!=0){
            return -1;
        }else{
            return level;
        }
        
    }
}