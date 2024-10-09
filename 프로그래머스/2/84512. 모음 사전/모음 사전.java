class Solution {
    static String Word;
    static int answer=0;
    static int count =0; 
    static char [] dict = {'A', 'E' , 'I', 'O','U'};
    public int solution(String word) {
        Word = word;
        StringBuilder sb =new StringBuilder();
        dfs(sb, 0);
        
        
        
        return answer;
    }
    
    static void dfs(StringBuilder sb , int cnt){
        int sum = 0; 
        if(sb.toString().equals(Word)){
            answer = count;                
            return;
            
        }
        
        if(cnt == 5){
            return; 
        }
        
        for(int i = 0 ; i< dict.length; i++){
            
            sb.append(dict[i]);
            count ++;
            dfs(sb, cnt+1);
            sb.deleteCharAt(sb.length()-1);
            
            
            
            
            
        }
            
    } 
}