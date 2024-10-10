import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i =0 ; i< reserve.length; i++){
            
            list.add(reserve[i]);
           
        }
        
        
        for(int i =0; i<lost.length;i++){
            
              if(list.contains(lost[i])){ // ** 다른 사람에게 체육복 못빌려줌 
                
              int idx = list.indexOf(lost[i]); 
                 list.remove(idx);
                  lost[i] =0;
                 answer++;
                 continue;
                  
                  
                  
                  
            }
            
        }
        
        
        for(int i =0; i<lost.length;i++){
        
        if(lost[i]!=0){
            if(list.contains(lost[i]-1)){
                
                int idx = list.indexOf(lost[i]-1); 
                list.remove(idx);
                answer++;
                continue;
            }
            
           
            
           
            if(list.contains(lost[i]+1)){
                
                int idx = list.indexOf(lost[i]+1); 
                list.remove(idx);
                answer++;
                continue;
            }
            
        }
             
            
            
            
        }
        
        
        
        return answer;
    }
}