import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int [] answer =null;
        
        int [] a = {1,2,3,4,5};
        int [] b = {2,1,2,3,2,4,2,5};
        int [] c = {3,3,1,1,2,2,4,4,5,5};
        
        int [] tmp = new int [4];
        
        for(int i = 0; i< answers.length ; i++){
            if(answers[i] == a[i%a.length]){
                tmp[1]++;
            }
            if(answers[i] == b[i%b.length]){
                tmp[2]++;
            }
            if(answers[i] == c[i%c.length]){
                tmp[3]++;
            }
            
        }
        
        int maxValue = Math.max(tmp[3], Math.max(tmp[1], tmp[2]));
        List <Integer> list = new ArrayList<>();
        if(maxValue == tmp[1]){
            
            list.add(1);
            
        }
         if(maxValue == tmp[2]){
            
            list.add(2);
            
        }
         if(maxValue == tmp[3]){
            
            list.add(3);
            
        }
      
        
        answer = list.stream().mapToInt(Integer :: intValue).toArray();
        
        
        return answer;
    }
}