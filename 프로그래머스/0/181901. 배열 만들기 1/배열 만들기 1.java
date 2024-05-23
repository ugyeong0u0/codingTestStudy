class Solution {
    public int[] solution(int n, int k) {
        
        int maxI = n/k ;
        
         int[] answer = new int[maxI];
        
        for(int i = 0 ; i<maxI; i++){
            
            answer[i]=(i+1)*k;
            
        }
        
        
        return answer;
    }
}