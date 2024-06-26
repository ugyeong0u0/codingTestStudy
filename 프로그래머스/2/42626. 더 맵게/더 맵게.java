import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        
        for(int i= 0 ; i< scoville.length; i++){
            
            pq.offer(scoville[i]);
            
        }
       // 두개 남았을 때, 하나 남았을 때 경우 

        while(pq.size()>1 && K>pq.peek()){
            
                answer++;    
                int a = pq.poll();
                int b = pq.poll();
                
                int tmp = a+(b*2);
                
                pq.offer(tmp);

        }
        // -1 인 경우
        if(pq.size()==1){
        int a= pq.peek();
            if(a<K)
                answer= -1;
       
        }
      
        return answer;
    }
}