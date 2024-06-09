class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        for(int i= 0; i<myString.length()-1;i++){
           
                String tmp = myString.substring(i);
                if(tmp.startsWith(pat)){
                
                    answer++;
                }    
            
            
        }
        
        
        
        return answer;
    }
}