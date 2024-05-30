class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int len = num_list.length;
        int arrL = 0; 
     
        for (int i = 1;i<=len;i+=n){
            if(i>len){
                break;
            }
        
            arrL++;
            
        }
        
        
        int[] answer = new int[arrL];
        int k = 0;
        
        for(int i =0; i<num_list.length; i+=n){
            
            answer[k++]= num_list[i];
        }
    
        return answer;
    }
}