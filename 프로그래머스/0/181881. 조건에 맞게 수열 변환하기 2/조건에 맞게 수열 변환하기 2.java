import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int [] arr2 = new int[arr.length];
        arr2 = Arrays.copyOfRange(arr, 0,arr.length);
        int flag = 0;
        
        while(true){
        
            answer++;
            for(int i =0; i< arr.length; i++){
                if(arr[i]>=50 && arr[i]%2==0){
                   
                    arr2[i]/=2;
                        
                   
                    
                }else if(arr[i]<50 && arr[i]%2!=0){

                    arr2[i]*=2;
                    arr2[i]++;
                    
                }
            }
            for(int i= 0 ; i<arr.length; i++){
                
                if(arr[i]!=arr2[i]){
                    flag =0;
                    break;
                }
                flag = 1; 
            }
            arr= Arrays.copyOfRange(arr2, 0, arr.length);
            if(flag ==1 ){
                break;
            }
            
        }
        
        answer--;
        
        
        return answer;
    }
}