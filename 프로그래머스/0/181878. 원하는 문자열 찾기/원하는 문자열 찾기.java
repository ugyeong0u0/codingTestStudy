class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        String tmpMyString= "";
        String tmpPat="";
        
        
        for(int i =0; i<myString.length(); i++){
            char tmpC = myString.charAt(i);
            if(tmpC>=97 && tmpC <=122){
                int a = tmpC-32;
                 char c=(char) a;
                 tmpMyString += Character.toString(c); // 모두 대문자로 변경     
            }else{
                 tmpMyString+=tmpC;
            }
        }
        
        
        for(int i =0; i<pat.length(); i++){
            char tmpC = pat.charAt(i);
            if(tmpC>=97 && tmpC <=122){
                  int a = tmpC-32;
                 char c= (char)a;
                 tmpPat += Character.toString(c); // 모두 대문자로 변경     
            }else{
                 tmpPat += tmpC;
            }
        }
        
        
        if(tmpMyString.contains(tmpPat)){
            answer= 1;
        }
        
        
        return answer;
    }
}