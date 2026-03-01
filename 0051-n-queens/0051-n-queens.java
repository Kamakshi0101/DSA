class Solution {
    public void backtrack(int row, Set<Integer> cols,
    Set<Integer> diags,
    Set<Integer> antiDiag,
    List<List<String>> boards,
    int n,
    char[][] game)
    {
        if(row==n)
        {
            List<String> board= new ArrayList<>();
            for(char[] r:game)
            {
                board.add(new String(r));
            }
            boards.add(board);
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(cols.contains(col)) continue;
            int diag=col-row;
            if(diags.contains(diag)) continue;
            int antidiag= col+row;
            if(antiDiag.contains(antidiag)) continue;

            cols.add(col);
            diags.add(diag);
            antiDiag.add(antidiag);

            game[row][col]='Q';

            backtrack(row+1,cols,diags,antiDiag,boards,n,game);
            cols.remove(col);
            diags.remove(diag);
            antiDiag.remove(antidiag);

            game[row][col]='.';
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards= new ArrayList<List<String>>();
        Set<Integer> cols= new HashSet<>();
        Set<Integer> diags= new HashSet<>();
        Set<Integer> antiDiag= new HashSet<>();

        char[][] game= new char[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                game[i][j]='.';
            }
        }
        backtrack(0,cols,diags,antiDiag,boards,n,game);
        return boards;
    }
}