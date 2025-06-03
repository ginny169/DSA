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
        int result = 0;
        Queue<String> queue = new LinkedList<>();
        String start = "0000";
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains(start)) return -1;

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()){
            int n = queue.size();

            for (int i = 0; i < n; i++){
                String cur = queue.poll();
                if (cur.equals(target)) return result;
                for (String next : getNextStates(cur)){
                    if (!dead.contains(next) && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            result++;
        }
        return -1;
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
