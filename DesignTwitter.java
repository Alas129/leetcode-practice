import java.util.*;

public class DesignTwitter {
    class Twitter {
        private Map<Integer, List<Tweet>> userTweets;
        private Map<Integer, Set<Integer>> userFollowees;
        private int timestamp;

        private static class Tweet {
            int timestamp;
            int tweetId;

            Tweet(int timestamp, int tweetId) {
                this.timestamp = timestamp;
                this.tweetId = tweetId;
            }
        }

        public Twitter() {
            userTweets = new HashMap<>();
            userFollowees = new HashMap<>();
            timestamp = 0;
        }

        public void postTweet(int userId, int tweetId) {
            timestamp++;
            if (!userTweets.containsKey(userId)) {
                userTweets.put(userId, new ArrayList<>());
            }
            userTweets.get(userId).add(new Tweet(timestamp, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

            // Add user's own tweets to the max heap
            if (userTweets.containsKey(userId)) {
                for (Tweet tweet : userTweets.get(userId)) {
                    maxHeap.offer(tweet);
                }
            }

            // Add followed users' tweets to the max heap
            if (userFollowees.containsKey(userId)) {
                for (int followeeId : userFollowees.get(userId)) {
                    if (userTweets.containsKey(followeeId)) {
                        for (Tweet tweet : userTweets.get(followeeId)) {
                            maxHeap.offer(tweet);
                        }
                    }
                }
            }

            // Get the top 10 recent tweets from the max heap
            List<Integer> feed = new ArrayList<>();
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                feed.add(maxHeap.poll().tweetId);
                count++;
            }

            return feed;
        }

        public void follow(int followerId, int followeeId) {
            if (!userFollowees.containsKey(followerId)) {
                userFollowees.put(followerId, new HashSet<>());
            }
            userFollowees.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userFollowees.containsKey(followerId)) {
                userFollowees.get(followerId).remove(followeeId);
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
