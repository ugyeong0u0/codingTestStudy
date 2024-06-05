class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String tmpString= "";
        for(char c: myString.toCharArray()){
            char tmp ;
            if(c=='A'){
                tmp ='B';
            }else if( c == 'B'){
                tmp = 'A';
            }else{
                tmp =c;
            }
            tmpString += tmp;
        }
        
        if(tmpString.contains(pat)){
            answer=1;
            
        }
        
        return answer;
    }
}