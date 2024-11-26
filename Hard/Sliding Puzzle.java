class Solution {
    Map<String, Boolean> map;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int slidingPuzzle(int[][] board) {
        map = new HashMap<>();
        int[] bits = new int[6];
        for(int i = 0; i < 6; i++)
            bits[i] = board[i / 3][i % 3];
        long ans = slidingPuzzle(bits, 0);
        return ans < Integer.MAX_VALUE ? (int)ans : -1;
    }

    public long slidingPuzzle(int[] bits, int depth) {
        // System.out.println(Arrays.toString(bits));
        if (isValid(bits))
            return depth;

        if (depth > 25)
            return Integer.MAX_VALUE;

        String bit = Arrays.toString(bits);
        map.put(bit, true);
        int cord = findZero(bits);
        int x = cord/3, y = cord%3;
        long min = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int i = x + dir[0], j = y + dir[1];
            if (i >= 0 && i < 2 && j >= 0 && j < 3) {
                bits[cord] = bits[i*3+j];
                bits[i*3+j] = 0;
                if (!map.containsKey(Arrays.toString(bits)))
                    min = Math.min(min, slidingPuzzle(bits, depth+1));
                bits[i*3+j] = bits[cord];
                bits[cord] = 0;
            }
        }
        map.remove(bit);
        return min;
    }


    public boolean isValid(int[] bits) {
        for (int i = 0; i <= 5; i++)
            if (bits[i] != (i + 1)%6)
                return false;
        return true;
    }

    public int findZero(int[] bits) {
        int i = 0;
        for (i = 0; i < 6; i++)
            if (bits[i] == 0)
                return i;
        return i;
    }
}
