class Solution {
    static final int[][] dirs ={{0,1}, {1,0}, {-1,0}, {0,-1}};
    private boolean solve(int curr, int i, int j, char[][] board, String word){
        //sucessfully matched entire word
        if(curr == word.length() - 1) return true;

        //Try all 4 adjancent directions
        for(int[]d: dirs){
            int x = i+d[0];
            int y = j+d[1];

            //validate bounds and character match
            if(x >=0 && x < board.length && y >=0 && y < board[0].length){
                if(board[x][y] == word.charAt(curr+1)){
                    char temp = board[x][y];
                    board[x][y] = '#'; // prevent revisiting
                    boolean ans = solve(curr+1, x, y, board, word);
                    board[x][y] = temp; //undo marking
                    if(ans) return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;

        // Iterate through every cell as potential starting point
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = '#'; // mark as visited
                    if(solve(0, i, j, board, word)) return true;
                    board[i][j] = temp; // restore
                }
            }
        }
        return false;
    }
}
