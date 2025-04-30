package org.example.java324.backtracking;

public class NQueen {
    static int result = 0;
    public static void main(String[] args) {
        int n = 4;
        result = totalNQueens(n);
        System.out.println(result);
    }

    public static int totalNQueens(int n) {
        backtrack(n,new boolean[n],new boolean[2*n], new boolean[2*n],0);
        return result;
    }

    public static void backtrack(int nums, boolean[] colume, boolean[] diag1, boolean[] diag2, int row) {
        //ddk dừng path.size() = k
        if (row == nums) {
            result = result +1;
            return;
        }

        // 4*4
        // --> 2 --> loại 1, 2
        //check đường cheó = tổng --> bỏ qua
        //check đường chéo có hiệu = nhau --> bỏ qua
        for (int i = 0; i < nums; i++) {
            if (!colume[i] && !diag1[i + row] && !diag2[i - row + nums]) {
                colume[i] = true;
                diag1[i + row] = true;
                diag2[i - row + nums] = true;
                backtrack(nums, colume, diag1, diag2, row+1);
                colume[i] = false;
                diag1[i + row] = false;
                diag2[i - row + nums] = false;
            }
        }
    }
}
