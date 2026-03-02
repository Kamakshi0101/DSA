class Solution {
    boolean isSudokuSolved=false;

    public void backtrack(int row,int col,char[][] board,int n,
    List<Set<Integer>> rows,List<Set<Integer>> cols,List<Set<Integer>> boxes)
    {
        if(board[row][col]!='.')
        {
            if(row==n-1 && col==n-1)
            {
                isSudokuSolved=true;
            }
            else
            {
                if(col==n-1)
                {
                    backtrack(row+1,0,board,n,rows,cols,boxes);
                }
                else
                {
                    backtrack(row,col+1,board,n,rows,cols,boxes);
                }
            }
        }
        else
        {
            for(int d=1;d<=9;d++)
            {
                if(rows.get(row).contains(d)) continue;
                if(cols.get(col).contains(d)) continue;
                int idx= (row/3)*3 + (col/3);
                if(boxes.get(idx).contains(d)) continue;

                rows.get(row).add(d);
                cols.get(col).add(d);
                boxes.get(idx).add(d);

                board[row][col]= (char)(d+'0');

                if(row==n-1 && col==n-1)
            {
                isSudokuSolved=true;
            }
            else
            {
                if(col==n-1)
                {
                    backtrack(row+1,0,board,n,rows,cols,boxes);
                }
                else
                {
                    backtrack(row,col+1,board,n,rows,cols,boxes);
                }
            }

            if(!isSudokuSolved)
            {
                board[row][col]='.';
                rows.get(row).remove(d);
                cols.get(col).remove(d);
                boxes.get(idx).remove(d);
            }

            }
        }
    }
    public void solveSudoku(char[][] board) {
        isSudokuSolved= false;
        List<Set<Integer>> rows= new ArrayList<>();
        List<Set<Integer>> cols= new ArrayList<>();
        List<Set<Integer>> boxes= new ArrayList<>();

        for(int i=0;i<board.length;i++)
        {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                    int dig= board[i][j]-'0';
                    int idx= (i/3)*3 + (j/3);

                    rows.get(i).add(dig);
                    cols.get(j).add(dig);
                    boxes.get(idx).add(dig);
                }
            }
        }
        backtrack(0,0,board,9,rows,cols,boxes);
    }
}