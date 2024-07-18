class Solution {
public int[] findDiagonalOrder(int[][] matrix) {
    int r = 0,c = 0,count= 0,inc = 0,f=0;
    int arr[] = new int[matrix.length*matrix[0].length];
    Boolean flag = true;
        while(flag){
            if(count%2==0 && f==0){
                List<Integer> l = new ArrayList<>();
                int rows = r;
                if(r!=matrix.length-1){
                   r++;
                }
                else{
                    f = 1;
                    r = 0;
                }
                while(rows>=0 && c<matrix[0].length){
                    l.add(matrix[rows--][c++]);
                }
                for(int i = 0;i<l.size();i++){
                    arr[inc++] = l.get(i);
                }
                count++;
                c = 0;
                l.clear();
            }
            else if(count%2==1 && f==0){
                List<Integer> l = new ArrayList<>();
                int rows = r;
                while(rows>=0 && c<matrix[0].length){
                    l.add(matrix[rows--][c++]);
                }
                Collections.reverse(l);
                for(int i = 0;i<l.size();i++){
                    arr[inc++] = l.get(i);
                }
                if(r!=matrix.length-1){
                   r++;
                }
                else{
                    f = 1;
                    r = 0;
                }
                count++;
                c = 0;
                l.clear();
            }
            else if(f==1){
                r = matrix.length-1;
                int rows = r;
                if(c!=matrix[0].length-1){
                    c++;
                }
                else{
                    flag = false;
                }
                if(flag){
                int col = c;
                List<Integer> l = new ArrayList<>();
                while(rows>=0 && col<matrix[0].length){
                    l.add(matrix[rows--][col++]);
                }
                if(count%2==1){
                    Collections.reverse(l);
                    count++;
                }
                else{
                    count++;
                }
                // System.out.println(l);
                for(int i = 0;i<l.size();i++){
                    arr[inc++] = l.get(i);
                }
                l.clear();
                }
            }
        }
        return arr;

    }
}
  
