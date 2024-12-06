class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();

        String startPieces = start.replace("_", "");
        String targetPieces = target.replace("_", "");

        if (!startPieces.equals(targetPieces)) {
            return false;
        }
        
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == '_') continue;
            
            while (target.charAt(j) == '_') j++;
            if (start.charAt(i) == 'L' && i < j) return false; 
            if (start.charAt(i) == 'R' && i > j) return false; 
            
            j++;
        }
        
        return true;
    }
}
