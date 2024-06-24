class Solution {
    private int dif(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(new Pair<>(startGene, 0));
        vis.add(startGene);

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String currGene = curr.getKey();
            int currSteps = curr.getValue();

            if (currGene.equals(endGene)) {
                return currSteps;
            }

            for (String gene : bank) {
                if (dif(currGene, gene) == 1 && !vis.contains(gene)) {
                    vis.add(gene);
                    q.add(new Pair<>(gene, currSteps + 1));
                }
            }
        }
        return -1;
    }
}
