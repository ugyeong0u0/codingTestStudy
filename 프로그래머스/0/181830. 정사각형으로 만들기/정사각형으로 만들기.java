class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = null;
        int rowL = arr.length;
        int colL = arr[0].length;
        if(rowL > colL){
            answer= new int[rowL][rowL];
        }else{
            answer= new int[colL][colL];
        }
        
        for(int i =0 ; i< rowL; i++){
            for(int j = 0; j< colL ;j++){
                
                answer[i][j] = arr[i][j];
                
            }
        }
        
        
        return answer;
    }
}