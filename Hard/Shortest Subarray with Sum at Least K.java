class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair<Integer, Long>> deque = new LinkedList<>(); 
        long sum = 0;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];

            
            if (sum >= k) {
                shortest = Math.min(shortest, i + 1); 
            }

            
            while (!deque.isEmpty() && (sum - deque.peekFirst().getValue() >= k)) {
                shortest = Math.min(shortest, i - deque.pollFirst().getKey());
            }

            
            while (!deque.isEmpty() && deque.peekLast().getValue() >= sum) {
                deque.pollLast();
            }

            
            deque.addLast(new Pair<>(i, sum));
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
