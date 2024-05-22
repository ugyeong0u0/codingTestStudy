import java.util.*;

class Solution {
    public String[] solution(String my_string) {
      
        
        List<String> arr= new ArrayList<>();
        
        int len = my_string.length();
        for(int i =0; i< len;i++){
    
            arr.add(my_string.substring(i));
            
        }
        
        // 정렬 
        Collections.sort(arr);
          String[] answer =new String[arr.size()];
        
        
        arr.toArray(answer);
        
        
        return answer;
    }
}