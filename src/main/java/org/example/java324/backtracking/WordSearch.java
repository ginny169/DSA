package org.example.java324.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(solver.exist(board, "ABCCED")); // true
        System.out.println(solver.exist(board, "SEE"));    // true
        System.out.println(solver.exist(board, "ABCB"));   // false
    }
    public boolean exist(char[][] board, String word) {
        int boardRow = board.length;
        int boardCol = board[0].length;
        for (int i = 0; i < boardRow; i++) {
            for (int j = 0; j < boardCol; j++){
               if(backtrack(board,word,i,j,0)){
                   return true;
               };
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()){
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length|| board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = temp;
        return found;
    }
}
