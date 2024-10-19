class Solution {
    /*
    1. for문 안에서 dfs(현재 배열 인덱스+ )
    dfs(현재 배열 인덱스 -)
    */
    static int answer=0;
    static int [] nums;
    static int t;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        t= target;
        
        dfs(0,0);
        
        
        return answer;
    }
    
    static void dfs(int prev, int dept){
      
        if(dept== nums.length){
            
            if(prev == t ){
                
                answer++;
            
            }
            return;
        }
      
        
        // for(int i =dept ; i<nums.length;i++){
            // System.out.println("prev  " +prev + "dept" +dept);
            dfs(prev+nums[dept], dept+1);
        // System.out.println("prev  " +prev + "dept" +dept);
            dfs(prev-nums[dept], dept+1);
            
            
        // }
        
        
        
    }
    
}


