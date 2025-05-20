package org.example.java324.backtracking;

public class LetterTilePossible {

    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
    }

    static int result = 0;

    public static int numTilePossibilities(String tiles) {
        backtrack(tiles, new StringBuilder(), new boolean[7]);
        return result;
    }

    public static void backtrack(String tiles, StringBuilder path, boolean[] position) {
        if (path.length() > 0) {
            System.out.println(path);
            result++;
        }
        boolean[] used = new boolean[26];
        for (int i = 0; i < tiles.length(); i++) {
            if (!position[i] && !used[tiles.charAt(i) - 'A']) {
                used[tiles.charAt(i) - 'A'] = true;
                position[i] = true;
                path.append(tiles.charAt(i));
                backtrack(tiles, path, position);
                position[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
