import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 0 1 3 5 6
        Arrays.sort(citations);
        
        int max = Integer.MIN_VALUE;
        int len = citations.length;
      
        
        int idx =Integer.MAX_VALUE; // 최소 인덱스
        
        for(int i = 0 ; i<= citations[len-1]; i++){
            int k=0; 
            for(int j =0; j<citations.length; j++){
                
                if(i<=citations[j]){
                    
                    k++;
                    
                }
                
            }
            if(k>= i){
                
                max= Math.max(max, i);
                
            }
       
        }
        if(max<-1){
            
            max=0;
            
            
        }
        
        return max;
    }
}