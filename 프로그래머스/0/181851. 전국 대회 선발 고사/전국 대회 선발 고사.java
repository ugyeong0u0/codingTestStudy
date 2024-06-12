import java.util.*;
class Solution {
    
    // 인덱스 : 학생번호 , 등수 : 인덱스 값 
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List <Integer> list = new ArrayList<Integer>();
        int k = 1;
        while(list.size()<3){
             
            for(int i = 0; i< rank.length; i++){
            
                if(rank[i]==k && attendance[i]==true){

                    list.add(i);
                    
                    break;
                 }
                
                
            }
            k++;
            
            
        }
            
            
            
        
        
       
        
        answer = list.get(0)*10000 + 100*list.get(1) +list.get(2);
        
        System.out.println(list.get(0)+ " "+ list.get(1)+" "+ list.get(2));
        
        return answer;
    }
}