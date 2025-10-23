import java.util.*;
class Solution {
    static int X, Y ;
    static int [][] result;
    public int solution(int[][] sizes) {
        int X = Integer.MIN_VALUE;
        int Y = Integer.MIN_VALUE;
        int answer = 0;
        int len=  sizes.length;
        result= new int [len+1][2];
        
        for(int i =0; i<len; i++){
            result[i][0] = Math.max(sizes[i][0],sizes[i][1]);
            result[i][1] = Math.min(sizes[i][0],sizes[i][1]);
            System.out.println(X + "    "+result[i][0] );
            System.out.println(Y + "    "+result[i][1] );
            X = Math.max(X,result[i][0]);
            Y = Math.max(Y,result[i][1]);
            
        }
        answer = X*Y ;
        
        return answer;
    }
}