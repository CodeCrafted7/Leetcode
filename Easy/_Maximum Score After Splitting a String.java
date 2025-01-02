class Solution {
  public int maxScore(String s) {
    var ones = 0;

    for (var c : s.toCharArray())
      if (c == '1') ones++;
    
    var zeros = 0;
    var max = 0;

    for (var i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '0') zeros++;
      else ones--;

      max = Math.max(max, zeros + ones);
    }
    return max;
  }
}
