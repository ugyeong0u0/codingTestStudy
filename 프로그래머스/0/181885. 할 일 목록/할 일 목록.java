class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = null;
        int k = 0;
        for(int i=0; i < finished.length; i++){
            
            if(finished[i]==false){
                
                k++;
            }
            
        }
        answer = new String[k];
        int m = 0;
        for(int j = 0 ; j< todo_list.length;j++){
            if(finished[j]==false){
             answer [m++] = todo_list[j] ;     
            }
        
        }
        
        
        return answer;
    }
}