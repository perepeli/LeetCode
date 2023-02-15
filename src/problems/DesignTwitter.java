package problems;

import java.util.*;

public class DesignTwitter {
    private static int timeStamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            next = null;
        }
    }

    class User {
        private int id;
        private Set<User> followees;
        Tweet tweetsLinkedList;

        public User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
        }

    }

    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) userMap.put(userId, new User(userId));
        User currentUser = userMap.get(userId);
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = currentUser.tweetsLinkedList;
        currentUser.tweetsLinkedList = newTweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) userMap.put(userId, new User(userId));
        User currentUser = userMap.get(userId);

        PriorityQueue<Tweet> userFeed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);

        if(currentUser.tweetsLinkedList != null) userFeed.add(currentUser.tweetsLinkedList);

        for(User u: currentUser.followees) {
            if(u.tweetsLinkedList != null) userFeed.add(u.tweetsLinkedList);
        }

        List<Integer> result = new ArrayList<>();

        int counter = 10;

        while(!userFeed.isEmpty() && counter > 0) {
            Tweet currentTweet = userFeed.poll();
            result.add(currentTweet.id);

            if(currentTweet.next != null) userFeed.add(currentTweet.next);

            counter--;
        }

        System.out.println(result);

        return result;

    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId , new User(followeeId));

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.add(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId , new User(followeeId));

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.remove(followee);

    }
}
