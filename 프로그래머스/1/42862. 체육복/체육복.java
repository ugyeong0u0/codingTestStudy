import java.util.*;
class Solution {
    static int [] visited;
    ArrayList <Integer> list = new ArrayList<>();
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        visited= new int [n+1];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        
        for(int i =0; i< lost.length; i++ ){
            int t = lost[i];
            visited[t]=1; // 체육복 없음
        }
        
        for(int i =0; i< reserve.length; i++ ){
            int t = reserve[i];
            if(visited[t]==1){
                visited[t]=0; // 체육복 있음
            }else{
                
                list.add(t);
            }
            
        }
        
        
        for(int i =0; i< list.size(); i++){
            
            int t = list.get(i);
             if(t-1>=1 && visited[t-1]==1){
                visited[t-1]=0;
            }else if( t+1 <=n && visited[t+1]==1){
                visited[t+1]=0;
            }
        }
        
        for(int i = 1; i< visited.length; i++){
            if(visited[i]==0){
                
                answer++;
            }
        }
        
        return answer;
    }
}