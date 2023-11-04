
class Solution {
    boolean checkTriplet(int[] arr, int n) {
      HashSet<Long>set=new HashSet<>();
      for(int i=0;i<n;i++){
          set.add((long)arr[i]*arr[i]);
      }
      
      
      for(int i=0;i<n-1;i++){
          for(int j=1;j<n;j++){
              long ans=(long)(arr[i]*arr[i])+(long)(arr[j]*arr[j]);
              if(set.contains(ans)){
                  return true;
              }
          }
      }
      return false;
    }
}
