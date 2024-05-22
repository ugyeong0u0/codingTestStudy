
import java.util.*;
class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        List<String> arr =new ArrayList<>();
        
        for(int i =0; i<my_string.length();i++){
            arr.add(my_string.substring(i));
            
        }
        
        for(int i =0 ; i<my_string.length();i++){
            if(arr.get(i).equals(is_suffix)){ // 실수: 처음엔 contains 사용함 
            answer=1;
            }
        }
        return answer;
    }
}