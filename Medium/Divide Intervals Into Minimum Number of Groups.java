class Solution {
    public int minGroups(int[][] inter) {
        int n = inter.length;
        Arrays.sort(inter, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int l = inter[i][0];
            int r = inter[i][1];

            if (pq.isEmpty()) {
                pq.add(r);
            } else {
                if (pq.peek() >= l) {
                    pq.add(r);
                } else {
                    pq.poll();
                    pq.add(r);
                }
            }
        }
        return pq.size();
    }
}
