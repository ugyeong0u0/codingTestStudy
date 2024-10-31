class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        int length = name.length();
        
        for(int i= 0; i< name.length() ;i++){
            
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            
            int index = i+1;
            
            while(index < name.length() && name.charAt(index)=='A'){
                index++;
            }
            
            
            move=Math.min(move, i+ length-index+Math.min(i, length-index));
            
        
        }
        System.out.println(answer);
        answer+= move;
        return answer;
    }
}