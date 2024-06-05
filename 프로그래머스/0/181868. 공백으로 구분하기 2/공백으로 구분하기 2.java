import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        String [] tmp = my_string.split(" ");
        List<String> arr = new ArrayList<>();
        
        for(String a : tmp){
           if(a.equals("")){
               continue;
           }else{
               arr.add(a);
           }
            
        }
        
        
        
        return arr.toArray(answer);
    }
    
}