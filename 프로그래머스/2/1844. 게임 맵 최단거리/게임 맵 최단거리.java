import java.util.*;

class Loc{
    
    int x ;
    int y;
     
    
    public Loc (int x , int y){
        
        this.x= x;
        this.y=y;
        
    }
    
}

class Solution {
    
    static int [] dx = {0,0,1,-1};
    static int [] dy = {+1,-1,0,0};
    static int [][] visited;
    static int [][] map;
    static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        
        map = maps;
        visited= new int [maps.length][maps[0].length];
        
        bfs();
        
        answer= visited[maps.length-1][maps[0].length-1];
        
        if(answer== 0){
            
           return answer =-1;
        }else
            return answer+1;
    }
    
    
    static void bfs(){
        Queue<Loc> q= new LinkedList<>();
        q.add(new Loc(0,0));
        
        while(!q.isEmpty()){
            Loc tmp = q.poll();
            
             for(int i = 0; i< 4; i++){
                int nx = dx[i]+ tmp.x;
                 int ny = dy[i]+ tmp.y;
            
                 if(nx >=0 && ny>=0 && nx< map.length &&  ny < map[0].length && visited[nx][ny]==0 && map[nx][ny]==1){
                
                visited[nx][ny]= visited[tmp.x][tmp.y]+1;
                q.add(new Loc(nx,ny));
                
            }
                 
                 
                 
               }
            
            
            
        }
        
       
        
        
        
        
        
    }
    
}