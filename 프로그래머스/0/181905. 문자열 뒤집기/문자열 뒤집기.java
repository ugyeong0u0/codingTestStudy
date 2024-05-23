class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        StringBuilder sb= new StringBuilder();
        
        for(int i = 0; i< s; i++){
            sb.append(my_string.charAt(i));
            
        }
        for(int j = e;j>=s ;j--){
              sb.append(my_string.charAt(j));
        }
        for(int k = e+1 ; k<my_string.length(); k++){
              sb.append(my_string.charAt(k));
            
        }
        
        answer = sb.toString();
        
        return answer;
    }
}