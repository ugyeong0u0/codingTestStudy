class Solution {
    static int answer, len ;
    static int [][] com ;
    static boolean [] flag;
    public int solution(int n, int[][] computers) {
        answer = 0;
        len =n;
        com =computers;
        flag= new boolean [n];
        // [[1, 1, 0],
        //  [1, 1, 0],
        //  [0, 0, 1]]
        // 섬 개수 구하기 
        
        for(int i = 0 ; i< n;i++){
            
            if(!flag[i]){
                answer++;
                dfs(i); // i는 start 
            }
            
        }
        
       
        
        
        return answer;
    }
    
    public void dfs(int start){
        flag[start]=true;
        for(int i = 0; i< len;i++ ){
            
            if(com[start][i]==1 && flag[i] ==false){
                dfs(i);
            }
        }
            
        
    }
}