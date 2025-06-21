package org.example.java324.graph.bfs;

import java.util.*;

public class WatchedVideosbyFriendLevelk {
    public static void main(String[] args) {
        int[][] friends = {{1},{0}};
        int id = 1;
        int level = 1;
        List<List<String>> watchedVideos = List.of(List.of("m"), List.of("xaqhyop","lhvh"));
        List<String> result = watchedVideosByFriends(watchedVideos,friends,id,level);
        for (String i : result){
            System.out.println(i);
        }

    }

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer> friendsList = new ArrayList<>();
        friendsList = getListFriendLevelk(friends, id, level);
//        for (int i: friendsList){
//            System.out.println(i);
//        }
        Map<String, Integer> map = new HashMap<>();
        for (Integer i : friendsList) {
            for (int j = 0; j < watchedVideos.get(i).size(); j++) {
                if (map.containsKey(watchedVideos.get(i).get(j))) {
                    map.put(watchedVideos.get(i).get(j), map.get(watchedVideos.get(i).get(j)) + 1);
                } else {
                    map.put(watchedVideos.get(i).get(j), 1);
                }
            }
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get((o2)))){
                return o1.compareTo(o2);
            } return map.get(o1) - map.get(o2);
        });
        return result;
    }


    public static List<Integer> getListFriendLevelk(int[][] friends, int id, int level) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{id, 0});
        boolean[] used = new boolean[friends.length];
        used[id] = true;

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[1] == level) {
                result.add(cur[0]);
            }
            for (int i = 0; i < friends[cur[0]].length; i++) {
                if (!used[friends[cur[0]][i]]) {
                    used[friends[cur[0]][i]] = true;
                    queue.add(new int[]{friends[cur[0]][i], cur[1] + 1});
                }
            }
        }
        return result;
    }
}
