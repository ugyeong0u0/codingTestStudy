class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if(arr1.length > arr2.length ){
            answer = 1;
        }else if(arr1.length < arr2.length){
            answer =-1;
        }else{
            int sum1 = 0;
            int sum2 = 0;
            for(int i  =0; i< arr1.length; i++){
                sum1+= arr1[i];
                
            }
            for(int j =0; j< arr2.length; j++){
                sum2+=arr2[j];
                
            }
            
            if(sum1 > sum2){
                answer=1;
            }else if(sum1< sum2){
                answer=-1;
            }else{
                answer= 0;
            }
        }
        
        
        
        return answer;
    }
}