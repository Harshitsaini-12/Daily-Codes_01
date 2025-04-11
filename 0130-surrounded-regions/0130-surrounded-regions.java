class Solution {
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0)return;

        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            if(board[i][0]=='O')helper(board,i,0);
            if(board[i][m-1]=='O')helper(board,i,m-1);
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O')helper(board,0,j);
            if(board[n-1][j]=='O')helper(board,n-1,j);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='*')board[i][j]='O';
               
            }
        }
    }

     private void helper(char[][]board,int r,int c){
        if(r<0 || c<0 || r>board.length-1 || c>board[0].length-1 || board[r][c]!='O')return;
        
        board[r][c]='*';
        
        helper(board,r+1,c);
        helper(board,r-1,c);
        helper(board,r,c+1);
        helper(board,r,c-1);
    }


}