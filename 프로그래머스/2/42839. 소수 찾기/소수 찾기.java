import java.util.*;
class Solution {
    
    static boolean [] visited;
    static int answer;
    static Set<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;
        visited = new boolean[7];
        
        dfs(numbers,"",0);      
        
        for(Integer r : hs){
            
            boolean res = odd(r);
            
            if(res){

                answer++;
            
            }
            
            
            
        }
        
        return answer;
    }
    
    static void dfs(String numbers, String s, int depth){
        if(depth > numbers.length()){
            return;
        }
        
        for(int i= 0; i< numbers.length();i++){
            char a= numbers.charAt(i);
        
            if(!visited[i]){
                visited[i]=true;
                hs.add(Integer.parseInt(s+a));
                dfs(numbers, a+s , depth+1);
                visited[i]=false;
            }
        }
        
    }
    
    static boolean odd(int a){
        
       if(a < 2){
           return false;
       }else{
           for(int i =2 ; i<=(int) Math.sqrt(a); i++){
               
               if(a%i==0){
                   return false;
               }
               
           }
       }
        return true;
    }
}