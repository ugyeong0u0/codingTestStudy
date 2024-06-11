import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = null;
        List <Integer> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            
            int flag = 0;
            for(int j = 0 ; j<delete_list.length; j++ ){
                
                if(delete_list[j]==arr[i]){
                    flag=1;
                }
                
            }
            if(flag== 0){
                list.add(arr[i]);
                
            }
            
        }
        
        answer = list.stream().mapToInt(Integer:: intValue).toArray();
        
        
        return answer;
    }
}