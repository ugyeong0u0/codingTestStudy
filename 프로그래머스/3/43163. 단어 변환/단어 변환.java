
class Solution {
    
    static int answer; 
    static int [] visited;
    static String [] word;
    static String t;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new int [words.length];
        word = words;
        t = target;
        
        dfs(begin, 0);
        
        if(answer==Integer.MAX_VALUE ){

            answer = 0;
        }
        
        return answer;
    }
    
    static void dfs(String begin, int count){
        
        if(begin.equals(t)){
            
            answer = Math.min(count,answer);
            return; 
            
        }
        
        for(int i =0; i<word.length; i++){
            
            if(visited[i]==0){
                String cur = word[i];
                int c =0;
                for(int j = 0; j<begin.length() ; j++){
                    
                    if(begin.charAt(j) != cur.charAt(j)){
                        c++;
                    }                
                }
                if(c==1){
                    visited[i]=1;
                    // System.out.println(begin+"->"+cur);
                    dfs(cur,count+1);
                    visited[i]=0;
                }
                
            }    
            
        }
        
        
        
    }
}