class Solution {
    public int[] solution(String myString) {
        int[] answer = null;
        int j = 0;
        
        for(int i = 0; i< myString.length(); i++){
            
            if(myString.charAt(i)=='x'){
                 j++;
                
            }
               
            
        }
        
        
        String [] tmp = myString.split("x");
        
       
        int len = tmp.length;
        

        
        answer = new int[j+1];
        for(int i = 0; i< len ;i++){
            
            answer[i]= tmp[i].length();
            
        }
        
        
        
        return answer;
    }
}