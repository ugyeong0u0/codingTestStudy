class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer= new int[2];
        // 카펫 가로 크기, 세로 크기 리턴 
        // 1. 갈 + 노랑 의 약수들 곱 
        // 2. 12 = (1,12) (2,6)(3,4)  (4,3)(6,2)(12,1)
        // 3. 이 중에서 가 > 세 (4,3)(6,2)(12,1)
        // 4. 세로 -2 * 세로 -2 = 노랑이가 정답 
        
        int total = brown + yellow; 
        
        for(int i =2 ; i<= Math.abs(total); i++){
            
            if(total %i ==0){
                int width =Math.max(total/i,i);
                int h =Math.min(total/i,i);
                
                if((width-2)*(h-2)==yellow){
                    answer[0]= width;
                    answer[1]= h;
                    
                }
                
                
            }
            
        }
        
        
        
        
        return answer;
    }
}