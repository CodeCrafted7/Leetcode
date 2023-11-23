class Solution {

public class Coordinate{
    int x , y;
    Coordinate(int x , int y){
        this.x = x;
        this.y = y;
    }
}

public boolean isValidCoordinate(int x , int y , List<List<Boolean>> visited){
    return x < visited.size() && y < visited.get(x).size() && !visited.get(x).get(y);
}

public int[] findDiagonalOrder(List<List<Integer>> nums) {
    Queue<Coordinate> queue = new LinkedList<>();
    List<List<Boolean>> visited = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    
    for(int i = 0 ; i < nums.size() ; i++){
        List<Boolean> row = new ArrayList<>();
        
        for(int j = 0 ; j < nums.get(i).size() ; j++) row.add(false);
        
        visited.add(row);
    }
    
    queue.add(new Coordinate(0,0));
    visited.get(0).set(0 , true);
    
    while(!queue.isEmpty()){
        Coordinate curr = queue.poll();
        
        res.add(nums.get(curr.x).get(curr.y));
        
        if(isValidCoordinate(curr.x + 1 , curr.y , visited)){
            queue.add(new Coordinate(curr.x + 1 , curr.y));
            visited.get(curr.x + 1).set(curr.y , true);
        }
        
        if(isValidCoordinate(curr.x , curr.y + 1 , visited)){
            queue.add(new Coordinate(curr.x , curr.y + 1));
            visited.get(curr.x).set(curr.y + 1 , true);
        }
    }
    
    
    return res.stream().mapToInt(i -> i).toArray();
}
}
