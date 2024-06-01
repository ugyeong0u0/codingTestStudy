import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue <Integer> q = new LinkedList<Integer>(); // 다리에 올라간 트럭 
        int sum =0; // 다리에 올라가 무게 합
        
        
        for(int i : truck_weights ){
            
            while(true){
                 // 1. 다리에 올라간게 하나도 없을 때
                if(q.isEmpty()){
                    q.add(i);
                    sum+=i;
                    answer++;
                    break;
                }else if(q.size() < bridge_length){ // 2. 한대는 올라가 있을 때 
                    
                    if(sum+i<=weight){
                        q.add(i);
                        sum+=i;
                        answer++;
                        break; // break 없을 시 while문으로 뺐다가 다시넣다가 무한루프 돔.
                    }else{
                        q.add(0);
                        answer++;
                    }
                    
                    
                }else{ // 3. 큐가 꽉 찼을 때
                    int tmp= q.poll();
                    sum-=tmp;
                    
                }
                
            }
            
        }
        answer+= bridge_length; // 생각못한 부분 
        
        
        return answer;
    }
}
/*
 - 초 세는게 이해 안갔음.  
1. 다리가 비어있을 때 
2. 1대 올렸을 때 
 1) 한 대 더 올릴 수 있을 때 
 2) 한대 더 못 올릴 때 
3. 다리가 2대로 꽉 찼을 때 
*/