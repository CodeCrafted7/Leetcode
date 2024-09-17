class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] buckets = new boolean[1440];
        int minTime = 1440, maxTime = -1;

        for (String time : timePoints) {
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            int minuteOfDay = hour * 60 + minute;

            if (buckets[minuteOfDay]) {
                return 0;
            }

            buckets[minuteOfDay] = true;
            minTime = Math.min(minTime, minuteOfDay);
            maxTime = Math.max(maxTime, minuteOfDay);
        }

        int minDiff = Math.min(1440 - maxTime + minTime, maxTime - minTime);
        int prev = minTime;

        for (int i = minTime + 1; i <= maxTime; i++) {
            if (buckets[i]) {
                minDiff = Math.min(minDiff, i - prev);
                prev = i;
            }
        }

        return minDiff;
    }
}
