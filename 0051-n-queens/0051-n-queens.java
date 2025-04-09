class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        
        char[][]grid=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        
        boolean[]row=new boolean[n];
        boolean[]col=new boolean[n];
        boolean[]dia=new boolean[n+n-1];
        boolean[]antidia=new boolean[n+n-1];
        
        solve(grid,n,ans,0,row,col,dia,antidia);
        return ans;
    }
    
    public void solve(char[][]grid,int n,List<List<String>>ans,int r,boolean[]row,boolean[]col,boolean[]dia,boolean[]antidia){
        
        if(r==n){
            List<String>sans=convert(grid,n);
            ans.add(sans);
            return;
        }
        
        for(int c=0;c<n;c++){
            if(!row[r] && !col[c] && !dia[r+c] && !antidia[r-c+n-1]){
               
                row[r]=col[c]=dia[r+c]=antidia[r-c+n-1]=true;
                grid[r][c]='Q';
                
                solve(grid,n,ans,r+1,row,col,dia,antidia);
                
                 row[r]=col[c]=dia[r+c]=antidia[r-c+n-1]=false;
                 grid[r][c]='.';
            }
        }
        return;
    }
    
    public List<String>convert(char[][]grid,int n){
        List<String>temp=new ArrayList<>();

        for(int j=0;j<n;j++){
            String temp1="";
            for(int i=0;i<n;i++){
                temp1+=grid[i][j];
            }
            temp.add(temp1);
        }
        return temp;
    }
}