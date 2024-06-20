class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        answer= dfs(k, dungeons);
        
        
        return answer;
    }
    
    
    static int dfs(int k, int [][]d){
        int cnt=0;
        for(int [] a : d){
            int a1 = a[0];
            int b1 = a[1];
            
            if(a1<=k){
                
                a[0]=9999;
                cnt=Math.max(1+dfs(k-b1,d),cnt);
                a[0]=a1;
                
            }
            
            
        }
        return cnt;
        
    }
    
   
}