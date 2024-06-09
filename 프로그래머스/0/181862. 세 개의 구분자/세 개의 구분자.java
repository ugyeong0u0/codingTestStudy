import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer = null;
        List <String> arr= new ArrayList<>();
        answer= myStr.split("a|b|c");
        if(answer.length==0){

            answer = new String[1];
            answer[0]="EMPTY";
        }else{
            for(int i=0 ; i< answer.length;i++){
            
                if(!answer[i].equals("")){
                    arr.add(answer[i]);
                }
            
            }
            answer = arr.toArray(new String[0]);
            
        }
        
        
        
        
        
        return answer;
    }
}