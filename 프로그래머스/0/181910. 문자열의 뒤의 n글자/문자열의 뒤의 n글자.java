class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        int len = my_string.length();
        int start = len - n;
        answer += my_string.substring(start,len);
        
        
        
        return answer;
    }
}