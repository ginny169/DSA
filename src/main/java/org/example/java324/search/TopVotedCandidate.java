package org.example.java324.search;

import java.util.HashMap;

public class TopVotedCandidate {
    public static void main(String[] args) {
        TopVotedCandidate topVoted = new TopVotedCandidate(
                new int[]{0, 1, 1, 0, 0, 1},
                new int[]{0, 5, 10, 15, 20, 25}
        );

        System.out.println(topVoted.q(3));
        System.out.println(topVoted.q(12));
        System.out.println(topVoted.q(25));
    }

    private int[] leaders;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leaders = new int[persons.length];

        HashMap<Integer, Integer> voteCount = new HashMap<>();
        int leader = -1;
        int maxVote = 0;
        for (int i = 0; i < persons.length; i++) {
            voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);
            if (voteCount.get(persons[i]) >= maxVote) {
                leader = persons[i];
                maxVote = voteCount.get(persons[i]);
            }
            leaders[i] = leader;
        }
    }

    //upper to find index của leaders (t and times)
    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        int ans = times.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > t) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leaders[ans-1];
    }
}
