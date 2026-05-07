import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n  - lost.length;
        int [] p = new int[n+1];        
        for(int i = 0; i< reserve.length; i++){
            int idx = reserve[i];
            p[idx]=1; // 체육복있음
        }
        // 여분있지만 && 뺏긴애
        for(int i = 0; i< lost.length; i++){
            int idx = lost[i]; // 잃어버린자 
            if(p[idx] == 1){
                p[idx]=2; // 여분 자기가 쓴
                answer++;
            }
            
        }
        
        for(int i = 0; i< lost.length; i++){
            int idx = lost[i]; // 잃어버린자 
            if(p[idx]!=2){
                 if(p[idx-1] == 1 && idx -1 >=1){
                    p[idx-1] = 0;  
                    answer ++;
                    continue;
                 }
                if(idx != n && p[idx+1] == 1){
                    p[idx+1] = 0;
                    answer ++; 
                    continue; 
                    
                  }
                 
            }
        }   
        
        
        return answer;
    }
}
