import java.util.*;

class Solution {
    
    static int [] x = {0, +1, 0, -1 };
    static int [] y = {-1, 0, +1, 0};
    
    static int answer =-1 ;
    static int lenX, lenY ;
    static int [][] visited;
    
    public int solution(int[][] maps) {
      
        lenX = maps.length;
        lenY = maps[0].length;
        visited = new int[lenX][lenY] ;
        
        
        
        bfs(maps);
      
        answer = visited[lenX-1][lenY-1];
        
        if(answer== 0){
            return -1;
        }
        
        return answer;
    }
    
    public void bfs(int [][] maps){
        
        Queue<int []> q= new LinkedList<>();
        
        q.offer(new int [] {0,0});
        
        visited[0][0]=1;
        
        while(!q.isEmpty()){
        
            int [] cur=  q.poll();
            
            int cx = cur[0];
            int cy = cur[1];
            
            
            for(int i =0 ; i< 4; i++){
                
                int nx = cx + x[i];
                int ny = cy + y[i];

            
           
            if(nx>=0 && nx<lenX && ny>=0 && ny<lenY && visited[nx][ny]==0&& maps[nx][ny]==1  ){
                visited[nx][ny]=visited[cx][cy]+1;
                q.offer(new int [] {nx,ny});
                
            }
            
        }
            
    }
        
        
        
    }
}