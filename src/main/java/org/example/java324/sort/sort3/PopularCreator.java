package org.example.java324.sort.sort3;

import java.util.*;

public class PopularCreator {
    public static void main(String[] args) {

        String[] creators = {"Alice", "Bob", "Alice", "Bob", "Alice"};
        String[] ids = {"id1", "id2", "id3", "id4", "id5"};
        int[] views = {100, 10, 150, 70, 300};

        List<List<String>> result = mostPopularCreator(creators, ids, views);

        // Print result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public static class Creator implements Comparable<Creator> {
        int totalView;
        int maxView;
        String videoName = "";

        @Override
        public int compareTo(Creator o) {
            if (this.totalView!=o.totalView){
                return  o.totalView - this.totalView;
            }
            return o.maxView - this.maxView;
        }
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
       // Tạo hashmap để lưu các dữ liệu vào chung để dễ comparator
        HashMap<String, Creator> result = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            int viewCount = views[i];
            String videoID = ids[i];

            result.putIfAbsent(creator, new Creator());

            Creator creatorData = result.get(creator);
            creatorData.totalView += viewCount;

            if (viewCount > creatorData.maxView) {
                creatorData.maxView = viewCount;
                creatorData.videoName = videoID;
            }
        }

        // sort creators theo total view
        List<Map.Entry<String, Creator>> sortedCreators = new ArrayList<>(result.entrySet());
        sortedCreators.sort((a,b)-> a.getValue().compareTo(b.getValue()));

        // Collect most popular creators
        List<List<String>> mostPopular = new ArrayList<>();
        int highestTotalView = -1;

        //xử lý dữ liệu đầu ra.
        for (Map.Entry<String, Creator> entry : sortedCreators){
            Creator creator = entry.getValue();
            String creatorName = entry.getKey();

            if (creator.totalView!=highestTotalView){
                mostPopular.add(new ArrayList<>());
                highestTotalView = creator.totalView;
            }

            mostPopular.get(mostPopular.size()-1).add(creatorName + " (" + creator.videoName + ")");

        }

        //in ra creatorName, VideoMaxViewName
        List<List<String>> formattedResult = new ArrayList<>();
        for (List<String> group : mostPopular){
            for (String entry : group){
                String[] parts = entry.split(" ");
                List<String> creatorInfo = new ArrayList<>();
                creatorInfo.add(parts[0]);
                creatorInfo.add(parts[1].replace("(", "").replace(")", ""));
                formattedResult.add(creatorInfo);
            }
        }
        return formattedResult;

    }

}
