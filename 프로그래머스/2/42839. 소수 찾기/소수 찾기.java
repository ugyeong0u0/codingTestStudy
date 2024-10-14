import java.util.*;
class Solution {
    
    static int [] visited;
    static Set<String> set = new HashSet<>();
    static Set<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new int [8];
        
        for( int i =1; i<= numbers.length(); i++){
            
            dfs(0,i,"", numbers);
            
            
        }
        
        for(String a : set ){
        
            isodd(a);

        }

        for(int a : hs){
            
            answer++;
        }
        
            
        return answer;
    }
    
    static void dfs(int n,int dept, String tmp, String numbers){
        
        if(n== dept){
            set.add(tmp);
        }
        
         for(int i = 0; i< numbers.length(); i++){
            
            char a= numbers.charAt(i);
            if(visited[i]==0){
                visited[i]=1;
                dfs(n+1, dept,tmp+a , numbers);
                visited[i]=0;
            
            }   
        }
    }
    
    
    static void isodd(String number ){
        
        int a = Integer.parseInt(number);
        if(a<2){
            return;    
        }
        for(int i = 2; i<Math.abs(a); i++){
            if(a%i==0){
                return;
            }
            
        }
        hs.add(a);
        
    
    }
}