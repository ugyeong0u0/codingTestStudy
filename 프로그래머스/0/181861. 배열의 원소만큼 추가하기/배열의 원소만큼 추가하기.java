class Solution {
    public int[] solution(int[] arr) {
        int[] answer = null;
        int sum=0;
        for(int k= 0; k< arr.length;k++){
            
            sum+=arr[k];
            
            
        }
        answer = new int[sum];
        int p = 0; 
        for(int i =0; i< arr.length;i++){
            for(int j =0 ; j< arr[i];j++){
                answer[p++] = arr[i];
            }
        
        
        }
        
        
        return answer;
    }
}