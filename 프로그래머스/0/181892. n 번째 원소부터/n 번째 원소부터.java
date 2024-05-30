class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] answer = new int[len-n+1];
        int k = 0;
        for(int i= n-1; i<len;i++){
        
            answer[k++]=num_list[i];
            
        }
        
        
        return answer;
    }
}