class Solution {
    public String solution(String myString) {
        String answer = "";
        
        String tmp = myString.toLowerCase();
        
        
        answer = tmp.replaceAll("a","A");
        
        return answer;
    }
}