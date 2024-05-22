import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        List<String> arr= new ArrayList<>();
        
        for(int i= 0; i<my_string.length(); i++){
            
            arr.add(my_string.substring(0,i));
            
        }
        
        for(int i= 0; i< my_string.length();i++){
            if(arr.get(i).equals(is_prefix)){
                answer =1 ; 
                
            }
            
        }
        
        
        
        
        return answer;
    }
}