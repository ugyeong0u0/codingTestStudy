class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        
        int total = brown + yellow;
        
        for(int i = 2; i<= brown; i++){ // brown까지만 for문 걸어도 됨
            
            if(total%i ==0){
                
                int t1 = total/i;
                int w = 0;
                int h = 0;
                if(t1 >i ){

                    w= t1;
                    h=i;
                }else{
                     w= i;
                    h=t1;
                }
                
                w-=2;
                h-=2;
                
                if(w*h==yellow){

                    answer[0]=w+2;
                    answer[1]=h+2;
                }
                
                
                
            }
            
        }
        
        
        
        
        
        return answer;
    }
}