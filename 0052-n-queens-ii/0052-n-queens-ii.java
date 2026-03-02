class Solution {
    int count;
    public void backtrack(int row,Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags,int n)
    {
        if(row==n)
        {
            count++;
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(cols.contains(col)) continue;
            int diag= col-row;
            if(diags.contains(diag)) continue;
            int anti= col+row;
            if(antiDiags.contains(anti)) continue;

            cols.add(col);
            diags.add(diag);
            antiDiags.add(anti);

            backtrack(row+1,cols,diags,antiDiags,n);

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(anti);
        }
    }
    public int totalNQueens(int n) {
        count=0;
        Set<Integer> cols= new HashSet<>();
        Set<Integer> diags= new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();
        backtrack(0,cols,diags,antiDiags,n);
        return count;
    }
}