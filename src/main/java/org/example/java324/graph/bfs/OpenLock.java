package org.example.java324.graph.bfs;

import java.util.*;

public class OpenLock {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target)); // Output: 6
    }
    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        return bfs(deadends, target, visited);
    }

    public static int bfs(String[] deadends, String target, Set<String> visited) {
        Queue<LevelOfString> queue = new LinkedList<>();
        String start = "0000";
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains(start)) return -1;

        queue.add(new LevelOfString(start,0));
        visited.add(start);

        while (!queue.isEmpty()){
             LevelOfString cur = queue.remove();
                if (cur.getTitle().equals(target)) return cur.getLevel();
                for (String next : getNextStates(cur.getTitle())){
                    if (!dead.contains(next) && !visited.contains(next)){
                        queue.add(new LevelOfString(next, cur.getLevel()+1));
                        visited.add(next);
                    }
                }
        }
        return -1;
    }

    public static class LevelOfString{
        private String title;
        private int level;

        public LevelOfString(String title,int level) {
            this.level = level;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int getLevel() {
            return level;
        }
    }

    private static List<String> getNextStates(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Quay lên
            chars[i] = original == '9' ? '0' : (char)(original + 1);
            res.add(new String(chars));

            // Quay xuống
            chars[i] = original == '0' ? '9' : (char)(original - 1);
            res.add(new String(chars));

            // Reset lại ký tự cũ để xử lý vị trí tiếp theo
            chars[i] = original;
        }

        return res;
    }
}
