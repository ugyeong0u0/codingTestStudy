import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        String[] answer = null;
        
        ArrayList <String> arr = new ArrayList<>();
        
        for(int i = 0; i< names.length; i+=5){
            
            arr.add(names[i]);
            
            
        }
        
        answer = new String[arr.size()];
        arr.toArray(answer);
        
        
        
        return answer;
    }
}