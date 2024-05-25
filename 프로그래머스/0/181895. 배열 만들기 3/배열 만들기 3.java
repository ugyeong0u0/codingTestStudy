class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = null;
        
      
        
        
        // 주어진 구간은 인덱스 값임!!
        int answerL = intervals[0][1]-intervals[0][0]+1+intervals[1][1]-intervals[1][0]+1;
        answer = new int[answerL];

        
        int k = 0;
        
      for(int i= intervals[0][0]; i<=intervals[0][1]; i++){
          answer[k++]=arr[i];
          
      }
    for (int j = intervals[1][0]; j<=intervals[1][1];j++){
           answer[k++]= arr[j]; 
            
        }
        
        return answer;
    }
}