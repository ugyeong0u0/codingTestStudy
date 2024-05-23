class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        int col = my_string.length()/m;
        char [][] st = new char[col][m];
        int k = 0;
        
        for(int i = 0; i<col; i++){
            for(int j = 0; j<m ; j++){
                
                if(k>=my_string.length()){
                    break;
                } 
                
                st[i][j] = my_string.charAt(k++);
                 
            }
        
        }
        for(int j= 0; j<col;j++){
            if(st[j][c-1]!=0)
            answer+=st[j][c-1];
            
        }
        
        
        return answer;
    }
}