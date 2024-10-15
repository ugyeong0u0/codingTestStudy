import java.util.*;
class Solution {
    // 인덱스가 아님  i j는
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i< commands.length; i++){
            int [] tmp;
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int idx = commands[i][2]-1;
            tmp = Arrays.copyOfRange(array,start, end );
            Arrays.sort(tmp);
            answer[i]= tmp[idx];
        }
        
        
        
        
        return answer;
    }
}