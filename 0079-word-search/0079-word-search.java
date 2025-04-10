class Solution {
    int[]di={-1,0,1,0};
    int[]dj={0,-1,0,1};

    public boolean helper(char[][]board,int i,int j,int si,String word){
        if(si==word.length())return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length)return false;

        if(board[i][j]!=word.charAt(si))return false;

        char mychar=board[i][j];
        board[i][j]='*';

        for(int d=0;d<4;d++){
            if(helper(board,i+di[d],j+dj[d],si+1,word)){
                board[i][j]=mychar;
                return true;
            }
        }

        board[i][j]=mychar;
        return false;

    }

    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!=word.charAt(0))continue;
                boolean res=helper(board,i,j,0,word);
                if(res)return true;
            }
        }

        return false;
    }
}