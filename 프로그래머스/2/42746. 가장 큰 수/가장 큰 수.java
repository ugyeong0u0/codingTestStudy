import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String [] n = new String[numbers.length];
        
        for(int i = 0 ; i< numbers.length; i++){ // 사전순인경우 10<3 임!
                
            n[i] = numbers[i]+"";
        }
        
        Arrays.sort(n, new Comparator<String>(){
            
            public int compare(String o1, String o2){ 
                
                return (o2+o1).compareTo(o1+o2);
                
            }
            
        });
        for (int i =0; i<n.length;i++){
            
            answer += n[i];
            
        }
        
        answer= answer.charAt(0) == '0' ? "0" : answer; 
        
        
        
        return answer;
    }
}