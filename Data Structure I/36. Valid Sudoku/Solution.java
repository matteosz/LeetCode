class Solution {
    public boolean isValidSudoku2(char[][] board) {/* Long Solution */
        
        HashSet<Character> rows, columns, boxes;
        
        for (int r=0;r<9;r++){
            rows = new HashSet<>();
            columns = new HashSet<>();
            boxes = new HashSet<>();
            for (int c=0;c<9;c++){
                if ((board[r][c]!='.' && !rows.add(board[r][c])) || (board[c][r]!='.' && !columns.add(board[c][r])))
                    return false;// check rows and columns
                int box_row = 3*(r/3), box_col = 3*(r%3);
                if (board[box_row + c/3][box_col + c%3] != '.' && !boxes.add(board[box_row + c/3][box_col + c%3]))// check sub-boxes
                    return false;
            }
        }         
        return true;        
    }
    /* Solution using parametrizing Strings (slower but clear) */
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i)
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }

        return true;
    }
}