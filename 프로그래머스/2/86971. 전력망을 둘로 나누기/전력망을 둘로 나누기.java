class Solution {
    
    static int N ; 
    static boolean [][] edges ;
    static boolean [] visited ;
    static int len;
    
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        N = n+1;
        len = wires.length;
        edges = new boolean [N][N];
        visited = new boolean[N]; // dfs에서 사용할 visited  
        
        // 배열 초기화 
        for(int i = 0 ; i< len ;i++){
            
            for(int j =0 ; j< 2; j++){
                
                int a = wires[i][0]; 
                int b = wires[i][1];
                
                edges[a][b] = true;
                edges[b][a] = true;
                
                
            }
            
        }
        
        
        // dfs로 간선 개수 찾기 
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i< len; i++){
            for(int  j = 0; j< 2; j++){
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                edges[a][b] = false;
                edges[b][a] = false;
                
                int Ia = dfs(a,0);
                int Ib = dfs(b,0); // 전선끊은 나머지 파트도 세야해서
                res = Math.min(res, Math.abs(Ia-Ib));
                
                edges[b][a] = true;
                edges[a][b] = true;
                    
                    
            }
           
            
        }
        
        answer = res; 
        
        return answer;
    }
    
    
    static int dfs(int loc , int cnt){
        
        if(visited[loc]){
            
            return 0;
            
        }
        int sum =1 ;
        visited[loc] = true;
        for(int i =0 ; i< N ; i++){
            
            if(!edges[loc][i]){
                
                continue;
                
            }
            
            sum+=dfs(i, cnt+1); // *****
            
            
        }
        
        visited[loc] = false ;
        
        
        
        
        return sum ; 
        
    }
}