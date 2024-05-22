class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        StringBuilder sb= new StringBuilder();
        
        int len = my_strings.length;
        int rowL = parts.length;
        int colL= parts[0].length;

   
           
            int i = 0; 
        for(int k =0;k <len;k++){

          
         
            
              if(i == rowL+1){
                break;
            }
                sb.append(my_strings[k].substring(parts[i][0],parts[i][1]+1)); 
           i++;
            
            
            
        }
        answer = sb.toString();
        return answer;
    }
}