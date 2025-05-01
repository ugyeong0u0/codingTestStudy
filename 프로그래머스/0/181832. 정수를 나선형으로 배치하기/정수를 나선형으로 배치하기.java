import java.util.*;
class Solution {
   
    static int nx = 1;
    static int ny = 1;
    static int nxEnd;
    static int nyEnd ;
    
        public int[][] solution(int n) {
        int[][] answer = new int [n+1][n+1];
        int [][] answer2 = new int [n][n];
        nxEnd = n;
        nyEnd = n;
        int now = 0; 
        while(now<n*n){
            
            // 1. ->  ny++이동
            for(int i=ny; i<=nyEnd ; i++){    
                answer[nx][i]= ++now;
            }
            nx++;
            // 2. 아래 , nx ++ 이동
            for(int i = nx ; i<= nxEnd ; i++){
                
                answer[i][nyEnd]=++now;
                
            }
            nyEnd--;
            
             // 3. <- , ny -- 이동
            for(int i = nyEnd ; i>=ny  ; i--){
                
                answer[nxEnd][i]=++now;
                
            }
            nxEnd--;
            // 4. 위, nx -- ;
            for(int i = nxEnd; i>=nx; i--){
                answer[i][ny]= ++ now;
            }
            
            ny++;
        
        }
           
        for(int i = 1; i<= n ; i++){
            for(int j =1; j<= n;j++){

            answer2[i-1][j-1] = answer[i][j];
            }
        }
        
        return answer2;
    }
}