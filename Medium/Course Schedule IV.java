class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> reachable = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            reachable.put(i, new HashSet<Integer>());
        }

        for(int[] prereq: prerequisites){
            int a = prereq[0], b = prereq[1];
            reachable.get(b).add(a);
        }
        
        for(int i = 0; i < numCourses; i++){
            for(int j = 0; j < numCourses; j++){
                if(reachable.get(j).contains(i))
                    reachable.get(j).addAll(reachable.get(i)); 
            }
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] query: queries){
            int u = query[0], v = query[1];
            result.add(reachable.get(v).contains(u));
        }

        return result;
    }
}
