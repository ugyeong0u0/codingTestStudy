class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        char tmpAlp = alp.charAt(0); 
        
        for(int i= 0; i< my_string.length(); i++){
            
            
            if(my_string.charAt(i)==tmpAlp){
                
                answer += alp.toUpperCase();
                
            }else{
                answer += my_string.charAt(i);
            }
            
            
        }
        
        return answer;
    }
}