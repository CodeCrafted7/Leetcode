class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curNum = 1;
        while (true){
            
            result.add(curNum);
            
            if (curNum * 10 <= n){
                curNum *= 10;
            } else { 
                if (curNum % 10 != 9 && curNum + 1 <= n) {
                    curNum += 1;
                } else { 
                    while (curNum > 0 && (curNum % 10 == 9 || curNum + 1 > n)){
                        curNum = curNum / 10;
                    }
                    if (curNum == 0) break;
                    curNum += 1;
                }
            }
        }
        return result;
    }

}
