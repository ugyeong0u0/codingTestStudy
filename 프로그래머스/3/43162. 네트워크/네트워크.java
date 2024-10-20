class Solution {
    
    static int [][] map;
    static int [][]visited;
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        map = computers;
        visited = new int [computers.length][computers[0].length];
        
        for(int i =0; i< n; i++){
            for(int j = 0; j<n ; j++){
               if(visited[i][j]==0 && map[i][j]==1){
                   
                   answer++;
                   visited[i][j]=1;
                   visited[j][i]=1;
                   
                   dfs(i,j);
                   
               } 
            }
        }
        
        
        
        return answer;
    }
    
    static void dfs(int a, int b){
        
        for(int i =0;i< map.length ; i++){
            
            if(visited[b][i]==0 && map[b][i]==1){
                
                visited[b][i]=1;
                visited[i][b]=1;
                dfs(b,i);
        
                
            }
        
        }
        
        
        
    }
    
    
    
}