class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int k = 1; 
        
        for(int i =0 ; i< num_list.length;i++){
            if(num_list.length>10){
                
                answer += num_list[i];
                
            }else{
                k*= num_list[i];
                
            }
            
        }
        if(k!=1){
            answer= k;
        }
        
        return answer;
    }
}