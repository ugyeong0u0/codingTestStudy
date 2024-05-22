class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        StringBuilder sb= new StringBuilder();
        
        int len = my_strings.length;
        int rowL = parts.length;
        int colL= parts[0].length;
            
        int i = 0; 

        /* 문제에서 my_strings와 parts의 인덱스 값이 같이 움직여야하기 때문에 하나의 for문 사용
       중첩 for문은 하나의 인덱스 당 다른 인덱스 순환일때 사용 */
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
