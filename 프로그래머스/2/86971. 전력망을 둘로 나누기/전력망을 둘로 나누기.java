class Solution {
    static int [][] visited;
    static int [][] maps;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
      
        maps = new int [n+1][n+1];
        
        for(int i = 0 ; i< wires.length; i++){
            for(int j =0 ; j<2;j++){
                
                int a = wires[i][0];
                int b = wires[i][1];

                maps[a][b]=1;
                maps[b][a]=1;
                
            }
        }
         
        for(int i = 0 ; i< wires.length; i++){
            for(int j =0 ; j<2;j++){
                int a = 0;
                int b = 0;

                    int a1 = wires[i][0];
                    int b1 = wires[i][1];
                
                    visited = new int [n+1][n+1];
                
                    maps[a1][b1]=0 ; // 연결 끊기
                    maps[b1][a1]=0;
                
                    a = dfs(a1,0,n);
                    b = dfs(b1,0,n);
                
                    maps[a1][b1]=1;
                    maps[b1][a1]=1;
                
                int tmp  = Math.abs(a-b);
                answer = Math.min(answer, tmp);
                
                
            }
        }
    
        return answer;
    }
    
    static int dfs(int number,int dept,int n){
        
        for(int i = 1; i<=n; i++){
            
            if(maps[number][i] == 1 && visited[number][i]==0){
                System.out.println(number + " ,  " +i);
                visited[number][i]=1;
                visited[i][number]=1;
               dept = dfs(i,dept+1,n);
            }
        
        }
        
        return dept;
        
    }
    
}