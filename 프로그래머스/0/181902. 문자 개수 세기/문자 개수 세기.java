class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        
        
        int len = my_string.length();
        
        for(int i=0; i<len;i++){
            
            if(65<=my_string.charAt(i) && my_string.charAt(i)<=90){
                answer[my_string.charAt(i)-65]++;
                
                
            }else if(97<= my_string.charAt(i) && my_string.charAt(i)<=122){
                answer[my_string.charAt(i)-97+26]++;
                
            }
            
        }
        
        
        
        return answer;
    }
}