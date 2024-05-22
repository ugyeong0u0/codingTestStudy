import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
       ArrayList<Integer> arr = new ArrayList<>();
       
        int len = intStrs.length;
        for(int i= 0; i<len;i++){
            if(intStrs[i].length()>s){
                String tmp = intStrs[i].substring(s,s+l);
                if(Integer.parseInt(tmp)>k){
                    arr.add(Integer.parseInt(tmp));
                    
                }
                
            }
            
            
        }
        
       int[] answer = new int[arr.size()];
       for(int i = 0; i<answer.length; i++){
           answer[i] = arr.get(i); 
           
       }
        
        return answer;
    }
}