package org.example.java324.backtracking;

public class WordSearch2 {
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//    Output: true

//    public static void main(String[] args){
//        char[][] board = {{"A"}}
//    }
    static boolean result = false;

    public boolean exist(char[][] board, String word) {
        result = false;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backtrack(board,word,i,j,0);
            }
        }
        return result;
    }

    public static void backtrack(char[][] board, String word, int row, int col, int index) {
                //base
        if (index == word.length()) {
            result = true;
        }
        if (col < 0 || col > board[0].length || row < 0 || row < board.length || index > word.length()) {
            return;
        }

        char x = board[row][col];

        if (board[row][col] == word.charAt(index)) {
            board[row][col] = '*';
            backtrack(board, word, row + 1, col, index + 1);
            backtrack(board, word, row -1 , col, index + 1);
            backtrack(board, word, row, col + 1, index + 1);
            backtrack(board, word, row, col - 1, index + 1);
            board[row][col] = x;
        }
    }
}
